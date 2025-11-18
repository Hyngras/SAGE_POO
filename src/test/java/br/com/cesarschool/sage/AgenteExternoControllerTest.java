package br.com.cesarschool.sage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.cesarschool.sage.controller.AgenteExternoController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(AgenteExternoController.class)
class AgenteExternoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // HU-014 — Portal do Agente Externo
    @Test
    void deveRetornarPortalAgente() throws Exception {
        mockMvc.perform(get("/dashboard/agente"))
                .andExpect(status().isOk())
                .andExpect(view().name("agente-externo"));
    }

    // HU-015.1 — Formulário: Solicitar manutenção corretiva
    @Test
    void deveRetornarFormularioManutencao() throws Exception {
        mockMvc.perform(get("/dashboard/solicitar-manutencao"))
                .andExpect(status().isOk())
                .andExpect(view().name("solicitar-manutencao"));
    }

    // HU-015.2 — Formulário: Avaliar serviço / funcionário
    @Test
    void deveRetornarFormularioAvaliacao() throws Exception {
        mockMvc.perform(get("/dashboard/avaliar-servico"))
                .andExpect(status().isOk())
                .andExpect(view().name("avaliar-servico"));
    }

    // HU-015.3 — Formulário: Solicitar instrução de equipamento
    @Test
    void deveRetornarFormularioInstrucao() throws Exception {
        mockMvc.perform(get("/dashboard/solicitar-instrucao"))
                .andExpect(status().isOk())
                .andExpect(view().name("solicitar-instrucao"));
    }
}
