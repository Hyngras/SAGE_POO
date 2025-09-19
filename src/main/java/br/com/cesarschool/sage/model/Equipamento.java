package br.com.cesarschool.sage.model;

import lombok.Data;
import java.util.List;

@Data // Anotação do Lombok para gerar getters, setters, toString(), etc.
public class Equipamento {
    private String id; // Identificador único
    private String patrimonio;
    private String tipo;
    private String fabricante;
    private String localizacao;
    private Criticidade criticidade;
    private StatusEquipamento status;
    private List<String> historicoManutencoes; // Lista de IDs das Ordens de Serviço
}