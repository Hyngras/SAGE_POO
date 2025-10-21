// package br.com.cesarschool.sage.controller;

// public class AdminController {
    
// }
package br.com.cesarschool.sage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/dashboard/admin")
    public String exibirDashboardAdmin(Model model) {
        // Dados fictícios que podem futuramente vir da autenticação
        model.addAttribute("nomeUsuario", "Amanda Ramalho");
        model.addAttribute("cargoUsuario", "Auxiliar Administrativo");

        // O Spring procura por src/main/resources/templates/adm-dashboard.html
        return "adm-dashboard";
    }
}