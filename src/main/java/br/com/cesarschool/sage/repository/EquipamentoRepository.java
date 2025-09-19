package br.com.cesarschool.sage.repository;

import br.com.cesarschool.sage.model.Criticidade;
import br.com.cesarschool.sage.model.Equipamento;
import br.com.cesarschool.sage.model.StatusEquipamento;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EquipamentoRepository {

    private static final String FILE_PATH = "dados_equipamentos.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Equipamento> equipamentos = new ArrayList<>();

    @PostConstruct
    public void init() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists() && file.length() > 0) {
                equipamentos = objectMapper.readValue(file, new TypeReference<>() {});
            } else {
                // Carga inicial de dados se o arquivo não existir
                Equipamento e1 = new Equipamento();
                e1.setId(UUID.randomUUID().toString());
                e1.setPatrimonio("NC-102030");
                e1.setTipo("Bomba de Infusão");
                e1.setFabricante("Medtronic");
                e1.setLocalizacao("UTI - Leito 02");
                e1.setCriticidade(Criticidade.ALTA);
                e1.setStatus(StatusEquipamento.OPERACIONAL);

                Equipamento e2 = new Equipamento();
                e2.setId(UUID.randomUUID().toString());
                e2.setPatrimonio("NC-405060");
                e2.setTipo("Monitor Cardíaco");
                e2.setFabricante("Philips");
                e2.setLocalizacao("Centro Cirúrgico - Sala 01");
                e2.setCriticidade(Criticidade.ALTA);
                e2.setStatus(StatusEquipamento.OPERACIONAL);

                equipamentos.add(e1);
                equipamentos.add(e2);
                saveAll();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Equipamento> findAll() {
        return new ArrayList<>(equipamentos);
    }

    public Optional<Equipamento> findById(String id) {
        return equipamentos.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public void save(Equipamento equipamento) {
        if (equipamento.getId() == null) {
            equipamento.setId(UUID.randomUUID().toString());
        }
        // Remove o antigo para garantir a atualização
        equipamentos.removeIf(e -> e.getId().equals(equipamento.getId()));
        equipamentos.add(equipamento);
        saveAll();
    }

    private void saveAll() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), equipamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}