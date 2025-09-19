package br.com.cesarschool.sage.controller;

import br.com.cesarschool.sage.model.Equipamento;
import br.com.cesarschool.sage.model.OrdemServico;
import br.com.cesarschool.sage.repository.EquipamentoRepository;
import br.com.cesarschool.sage.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @GetMapping("/")
    public String dashboard(Model model) {
        // 1. Buscamos todos os equipamentos e todas as O.S.
        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        List<OrdemServico> ordensServico = ordemServicoRepository.findAll();

        // 2. Criamos um "mapa" para facilitar a busca de equipamentos pelo ID.
        //    Isso é muito mais eficiente do que procurar na lista várias vezes.
        Map<String, Equipamento> equipamentoMap = equipamentos.stream()
                .collect(Collectors.toMap(Equipamento::getId, Function.identity()));

        // 3. Enviamos tudo para o frontend.
        model.addAttribute("equipamentos", equipamentos);
        model.addAttribute("ordensServico", ordensServico);
        model.addAttribute("equipamentoMap", equipamentoMap); // <-- AQUI ESTÁ A MÁGICA!

        return "dashboard"; // Renderiza o arquivo dashboard.html
    }
}