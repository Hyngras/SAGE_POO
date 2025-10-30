package br.com.cesarschool.sage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventarioController {

    @GetMapping("/admin/inventario")
    public String exibirInventario(Model model) {
        // Estes dados podem vir futuramente do banco
        model.addAttribute("nomeUsuario", "Amanda Ramalho");
        model.addAttribute("cargoUsuario", "Auxiliar Administrativo");
        return "admin-inventario"; 
    }

}