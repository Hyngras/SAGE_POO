package br.com.cesarschool.sage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardEngenheiroController {

    // Classe simples para representar os serviços nos cards
    // Em um projeto real, esta seria uma classe do seu pacote 'model'
    record Servico(String nome, String local) {}

    @GetMapping("/dashboard/engenheiro")
    public String engenheiroDashboard(Model model) {

        // Dados de exemplo para o card "SOLICITAÇÕES"
        List<String> solicitacoes = List.of(
                "João Silva - MONITOR MULTIPARAMÉDICO (ENFERMARIA - 5º andar)",
                "Adam Sumeriano - MONITOR MULTIPARAMÉDICO (ENFERMARIA - 5º andar)"
        );

        // Dados de exemplo para o card "SERVIÇOS AGENDADOS"
        List<Servico> servicosAgendados = List.of(
                new Servico("Madalena Aqua", "BLOCO CIRURGICO"),
                new Servico("Julio Bim", "BLOCO CIRURGICO"),
                new Servico("Mariana Clarim", "ENFERMARIA"),
                new Servico("DIEGO RODRIGUES", "UTI")
        );

        // Dados de exemplo para o card "SERVIÇOS PENDENTES"
        List<Servico> servicosPendentes = List.of(
                new Servico("Madalena Aqua", "ENFERMARIA"),
                new Servico("Julio Bim", "ENFERMARIA")
        );

        // Adicionando os dados ao Model para que o Thymeleaf possa usá-los
        model.addAttribute("solicitacoes", solicitacoes);
        model.addAttribute("servicosAgendados", servicosAgendados);
        model.addAttribute("servicosPendentes", servicosPendentes);

        // Retorna o nome do ficheiro HTML para ser renderizado
        return "engenheiro-dashboard";
    }
}