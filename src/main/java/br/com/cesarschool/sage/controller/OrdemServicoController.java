package br.com.cesarschool.sage.controller;

import br.com.cesarschool.sage.model.Solicitacao;
import br.com.cesarschool.sage.service.SolicitacaoService; // 1. Importe o serviço
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class OrdemServicoController {

    private final SolicitacaoService solicitacaoService;

    // 2. Injetando o serviço no construtor (melhor prática)
    public OrdemServicoController(SolicitacaoService solicitacaoService) {
        this.solicitacaoService = solicitacaoService;
    }

    @GetMapping("/os/abrir")
    public String exibirFormularioAberturaOS(@RequestParam Long solicitacaoId, Model model) {

        // 3. AQUI ESTÁ A CORREÇÃO PRINCIPAL:
        // Buscamos a solicitação usando o serviço, que lê o arquivo JSON.
        Solicitacao solicitacao = solicitacaoService.findById(solicitacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Solicitação com ID inválido: " + solicitacaoId));

        // Se a solicitação foi encontrada, o código continua normalmente.
        model.addAttribute("solicitacao", solicitacao);

        // Dados de exemplo para o dropdown de técnicos
        List<String> tecnicos = List.of("Han Solo", "Luke Skywalker", "Leia Organa");
        model.addAttribute("tecnicos", tecnicos);

        return "abrir-os"; // Retorna o nome do arquivo HTML do formulário
    }
}