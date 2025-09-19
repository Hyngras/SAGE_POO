package br.com.cesarschool.sage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Retorna o nome do ficheiro HTML: "login.html"
    }
}