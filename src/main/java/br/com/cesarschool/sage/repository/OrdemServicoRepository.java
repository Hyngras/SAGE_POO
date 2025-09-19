package br.com.cesarschool.sage.repository;

import br.com.cesarschool.sage.model.OrdemServico;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class OrdemServicoRepository {

    private static final String FILE_PATH = "dados_os.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<OrdemServico> ordensServico = new ArrayList<>();

    public OrdemServicoRepository() {
        // Módulo para permitir que o Jackson trabalhe com datas (LocalDateTime)
        objectMapper.registerModule(new JavaTimeModule());
    }

    @PostConstruct
    public void init() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists() && file.length() > 0) {
                ordensServico = objectMapper.readValue(file, new TypeReference<>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<OrdemServico> findAll() {
        return new ArrayList<>(ordensServico);
    }

    public Optional<OrdemServico> findById(String id) {
        return ordensServico.stream().filter(os -> os.getId().equals(id)).findFirst();
    }

    public void save(OrdemServico os) {
        if (os.getId() == null) {
            os.setId(UUID.randomUUID().toString());
        }
        ordensServico.removeIf(o -> o.getId().equals(os.getId()));
        ordensServico.add(os);
        saveAll();
    }

    private void saveAll() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), ordensServico);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}