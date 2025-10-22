package br.com.cesarschool.sage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminController {

    @GetMapping("/dashboard/admin")
    public String exibirDashboardAdmin(Model model) {
        model.addAttribute("nomeUsuario", "Amanda Ramalho");
        model.addAttribute("cargoUsuario", "Auxiliar Administrativo");

        return "adm-dashboard";
    }
}