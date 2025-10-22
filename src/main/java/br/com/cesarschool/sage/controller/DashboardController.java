package br.com.cesarschool.sage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    // @GetMapping("/dashboard-admin")
    // public String dashboardAdmin() {
    //     return "dashboard-admin";
    // }

    @GetMapping("/dashboard-engenheiro")
    public String dashboardEngenheiro() {
        return "engenheiro-dashboard";
    }

    @GetMapping("/teste-erro")
    public String testeErro() {
        // Esta linha irá forçar uma exceção
        throw new RuntimeException("Este é um erro de teste para exibir a página personalizada!");
    }
}