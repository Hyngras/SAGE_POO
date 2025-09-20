package br.com.cesarschool.sage.controller;

import br.com.cesarschool.sage.model.Equipamento;
import br.com.cesarschool.sage.model.OrdemServico;
import br.com.cesarschool.sage.repository.EquipamentoRepository;
import br.com.cesarschool.sage.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {


        return "login.html";
    }
}