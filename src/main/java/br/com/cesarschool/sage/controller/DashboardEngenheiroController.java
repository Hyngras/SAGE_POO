package br.com.cesarschool.sage.controller;

import br.com.cesarschool.sage.model.Servico;
import br.com.cesarschool.sage.model.Solicitacao;
import br.com.cesarschool.sage.service.ServicoService;
import br.com.cesarschool.sage.service.SolicitacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class DashboardEngenheiroController {

    private final SolicitacaoService solicitacaoService;
    private final ServicoService servicoService;

    // Injetando ambos os serviços no construtor
    public DashboardEngenheiroController(SolicitacaoService solicitacaoService, ServicoService servicoService) {
        this.solicitacaoService = solicitacaoService;
        this.servicoService = servicoService;
    }

    @GetMapping("/dashboard/engenheiro")
    public String engenheiroDashboard(Model model) {
        // 1. Busca as solicitações do arquivo JSON através do serviço
        List<Solicitacao> solicitacoes = solicitacaoService.findAll();

        // 2. Busca os serviços agendados do arquivo JSON através do serviço
        List<Servico> servicosAgendados = servicoService.findServicosAgendados();

        // 3. Busca os serviços pendentes do arquivo JSON através do serviço
        List<Servico> servicosPendentes = servicoService.findServicosPendentes();

        // Adicionando todos os dados carregados ao Model
        model.addAttribute("solicitacoes", solicitacoes);
        model.addAttribute("servicosAgendados", servicosAgendados);
        model.addAttribute("servicosPendentes", servicosPendentes);

        // Retorna o nome do ficheiro HTML para ser renderizado
        return "engenheiro-dashboard";
    }
}