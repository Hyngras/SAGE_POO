package br.com.cesarschool.sage.controller;

import br.com.cesarschool.sage.service.SolicitacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController // Usamos @RestController para APIs que retornam dados (e não views HTML)
public class SolicitacaoController {

    private final SolicitacaoService solicitacaoService;

    public SolicitacaoController(SolicitacaoService solicitacaoService) {
        this.solicitacaoService = solicitacaoService;
    }

    @DeleteMapping("/solicitacoes/{id}")
    public ResponseEntity<Void> deletarSolicitacao(@PathVariable Long id) {
        boolean deletado = solicitacaoService.deleteById(id);

        if (deletado) {
            // Retorna 200 OK se foi deletado com sucesso
            return ResponseEntity.ok().build();
        } else {
            // Retorna 404 Not Found se a solicitação com aquele ID não foi encontrada
            return ResponseEntity.notFound().build();
        }
    }
}