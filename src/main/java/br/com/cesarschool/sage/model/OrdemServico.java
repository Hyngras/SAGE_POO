package br.com.cesarschool.sage.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrdemServico {
    private String id;
    private String equipamentoId; // Link para o equipamento
    private String descricaoProblema;
    private PrioridadeOS prioridade;
    private StatusOS status;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private String relatorioFechamento;
}