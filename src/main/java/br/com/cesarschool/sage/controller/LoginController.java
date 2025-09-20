package br.com.cesarschool.sage.controller;

import br.com.cesarschool.sage.model.LoginInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String senha,
            @RequestParam String departamento,
            RedirectAttributes redirectAttributes) {

        try {
            LoginInfo info = new LoginInfo();
            info.setEmail(email);
            info.setSenha(senha);
            info.setDepartamento(departamento);

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("login-info.json"), info);

            if ("engenheiro-clinico".equalsIgnoreCase(departamento)) {
                return "redirect:/dashboard/engenheiro";
            } else if ("agente-externo".equalsIgnoreCase(departamento)) {
                return "redirect:/dashboard/agente";
            } else if ("admin".equalsIgnoreCase(departamento)) {
                return "redirect:/dashboard/admin";
            } else {
                return "redirect:/error";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao fazer login.");
            return "redirect:/login";
        }
    }
}