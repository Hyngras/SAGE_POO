package br.com.cesarschool.sage.model;

public record Solicitacao(
        long id,
        String solicitante,
        String equipamento,
        String setor,
        String data,
        String descricaoProblema
) {}