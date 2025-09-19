package br.com.cesarschool.sage.controller;

import br.com.cesarschool.sage.model.OrdemServico;
import br.com.cesarschool.sage.model.PrioridadeOS;
import br.com.cesarschool.sage.repository.EquipamentoRepository;
import br.com.cesarschool.sage.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/os")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @GetMapping("/nova/{equipamentoId}")
    public String showFormOs(@PathVariable String equipamentoId, Model model) {
        OrdemServico os = new OrdemServico();
        os.setEquipamentoId(equipamentoId);

        model.addAttribute("os", os);
        model.addAttribute("equipamento", equipamentoRepository.findById(equipamentoId).get());
        model.addAttribute("prioridades", PrioridadeOS.values());

        return "form-os";
    }

    @PostMapping("/salvar")
    public String salvarOs(@ModelAttribute OrdemServico os) {
        ordemServicoService.abrirOS(os);
        return "redirect:/";
    }

    @PostMapping("/fechar/{osId}")
    public String fecharOs(@PathVariable String osId) {
        // Em um sistema real, o relatório viria de um formulário
        String relatorioSimples = "Manutenção concluída com sucesso.";
        ordemServicoService.fecharOS(osId, relatorioSimples);
        return "redirect:/";
    }
}