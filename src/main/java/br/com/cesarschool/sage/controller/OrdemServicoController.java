package br.com.cesarschool.sage.controller;

import br.com.cesarschool.sage.model.Solicitacao;
import br.com.cesarschool.sage.service.SolicitacaoService; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class OrdemServicoController {

    private final SolicitacaoService solicitacaoService;

    public OrdemServicoController(SolicitacaoService solicitacaoService) {
        this.solicitacaoService = solicitacaoService;
    }

    // --------------- codigo antigo ----------

    @GetMapping("/os/abrir")
    public String exibirFormularioAberturaOS(@RequestParam Long solicitacaoId, Model model) {

        Solicitacao solicitacao = solicitacaoService.findById(solicitacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Solicitação com ID inválido: " + solicitacaoId));

        model.addAttribute("solicitacao", solicitacao);

        List<String> tecnicos = List.of("Han Solo", "Luke Skywalker", "Leia Organa");
        model.addAttribute("tecnicos", tecnicos);

        return "abrir-os"; 
    }

    // --------------- alteracao 1 ----------------------
    // @GetMapping("/os/abrir")
    // public String exibirFormularioAberturaOS(@RequestParam Long solicitacaoId, Model model) {

    //     Solicitacao solicitacao = solicitacaoService.findById(solicitacaoId)
    //             .orElseThrow(() -> new IllegalArgumentException("Solicitação com ID inválido: " + solicitacaoId));

    //     // adicoes e alteracoes aqui tb
    //     solicitacao.setCategoria("ELETRICA");
    //     solicitacao.setPrazo(3);
    //     solicitacao.setObservacoes("Equipamento foi relatado como desligando sozinho após 2 horas de uso contínuo.");
    //     solicitacao.setAnexoUrl("/uploads/foto-bomba.jpg"); // precisa criar campo String na classe Solicitacao

    //     model.addAttribute("solicitacao", solicitacao);

    //     List<String> tecnicos = List.of("Han Solo", "Luke Skywalker", "Leia Organa");
    //     model.addAttribute("tecnicos", tecnicos);

    //     return "abrir-os";
    // }

    // alteracao2 ----------------
    // @GetMapping("/os/abrir")
    // public String exibirFormularioAberturaOS(@RequestParam Long solicitacaoId, Model model) {

    //     Solicitacao base = solicitacaoService.findById(solicitacaoId)
    //             .orElseThrow(() -> new IllegalArgumentException("Solicitação com ID inválido: " + solicitacaoId));

    //     // Cria um novo record já com os campos extras preenchidos
    //     Solicitacao solicitacao = new Solicitacao(
    //             base.id(),
    //             base.solicitante(),
    //             base.equipamento(),
    //             base.setor(),
    //             base.data(),
    //             base.descricaoProblema(),
    //             "ELETRICA",       
    //             3,               
    //             "Equipamento relatado como desligando sozinho após 2 horas de uso",
    //             "/uploads/foto-bomba.jpg" 
    //     );

    //     model.addAttribute("solicitacao", solicitacao);

    //     List<String> tecnicos = List.of("Han Solo", "Luke Skywalker", "Leia Organa");
    //     model.addAttribute("tecnicos", tecnicos);

    //     return "abrir-os";
    // }


}