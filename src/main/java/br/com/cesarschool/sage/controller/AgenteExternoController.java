package br.com.cesarschool.sage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; // Importe este

@Controller
@RequestMapping("/dashboard") // Vamos agrupar as rotas
public class AgenteExternoController {

    @GetMapping("/agente")
    public String portalAgenteExterno() {
        return "agente-externo";
    }

    // ROTA PARA A TELA 1
    @GetMapping("/solicitar-manutencao")
    public String solicitarManutencao() {
        return "solicitar-manutencao";
    }

    // ROTA PARA A TELA 2
    @GetMapping("/avaliar-servico")
    public String avaliarServico() {
        return "avaliar-servico";
    }

    // ROTA PARA A TELA 3
    @GetMapping("/solicitar-instrucao")
    public String solicitarInstrucao() {
        return "solicitar-instrucao";
    }
}