package br.com.cesarschool.sage.service;

import br.com.cesarschool.sage.model.Equipamento;
import br.com.cesarschool.sage.model.OrdemServico;
import br.com.cesarschool.sage.model.StatusEquipamento;
import br.com.cesarschool.sage.model.StatusOS;
import br.com.cesarschool.sage.repository.EquipamentoRepository;
import br.com.cesarschool.sage.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    // Implementa as regras de negócio da HU-003
    public void abrirOS(OrdemServico os) {
        Equipamento equipamento = equipamentoRepository.findById(os.getEquipamentoId())
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado!"));

        os.setStatus(StatusOS.ABERTA);
        os.setDataAbertura(LocalDateTime.now());
        ordemServicoRepository.save(os);

        equipamento.setStatus(StatusEquipamento.EM_MANUTENCAO);
        equipamentoRepository.save(equipamento);
    }

    // Implementa as regras de negócio da HU-005
    public void fecharOS(String osId, String relatorio) {
        OrdemServico os = ordemServicoRepository.findById(osId)
                .orElseThrow(() -> new RuntimeException("Ordem de Serviço não encontrada!"));

        Equipamento equipamento = equipamentoRepository.findById(os.getEquipamentoId())
                .orElseThrow(() -> new RuntimeException("Equipamento associado não encontrado!"));

        os.setStatus(StatusOS.FECHADA);
        os.setDataFechamento(LocalDateTime.now());
        os.setRelatorioFechamento(relatorio);
        ordemServicoRepository.save(os);

        equipamento.setStatus(StatusEquipamento.OPERACIONAL);
        equipamentoRepository.save(equipamento);
    }
}