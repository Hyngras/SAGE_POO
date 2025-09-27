package br.com.cesarschool.sage.service;

import br.com.cesarschool.sage.model.Servico;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

    private final ObjectMapper objectMapper;

    public ServicoService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Carrega a lista de serviços agendados do arquivo JSON.
     * @return Uma lista de objetos Servico.
     */
    public List<Servico> findServicosAgendados() {
        return loadServicosFromFile("data/servicos-agendados.json");
    }

    /**
     * Carrega a lista de serviços pendentes do arquivo JSON.
     * @return Uma lista de objetos Servico.
     */
    public List<Servico> findServicosPendentes() {
        return loadServicosFromFile("data/servicos-pendentes.json");
    }

    /**
     * Método genérico para ler um arquivo de serviços.
     * @param filePath O caminho para o arquivo JSON.
     * @return Uma lista de objetos Servico.
     */
    private List<Servico> loadServicosFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>(); // Retorna lista vazia se o arquivo não existe ou está vazio
        }
        try {
            return objectMapper.readValue(file, new TypeReference<List<Servico>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}