package br.com.cesarschool.sage.service;

import br.com.cesarschool.sage.model.Solicitacao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {

    private static final String FILE_PATH = "data/solicitacoes.json";
    private final ObjectMapper objectMapper;

    public SolicitacaoService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // Método sincronizado para evitar problemas de concorrência ao ler o arquivo
    public synchronized List<Solicitacao> findAll() {
        File file = new File(FILE_PATH);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>(); // Retorna lista vazia se o arquivo não existe ou está vazio
        }
        try {
            return objectMapper.readValue(file, new TypeReference<List<Solicitacao>>() {});
        } catch (IOException e) {
            // Em uma aplicação real, logar o erro é crucial
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Optional<Solicitacao> findById(Long id) {
        return findAll().stream()
                .filter(s -> s.id() == id)
                .findFirst();
    }

    public synchronized boolean deleteById(Long id) {
        List<Solicitacao> solicitacoes = new ArrayList<>(findAll());

        // Usa removeIf para encontrar e remover o item com o ID correspondente
        boolean removed = solicitacoes.removeIf(s -> s.id() == id);

        // Se um item foi removido, reescreve o arquivo com a lista atualizada
        if (removed) {
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), solicitacoes);
            } catch (IOException e) {
                e.printStackTrace();
                return false; // Retorna false se houver erro ao escrever no arquivo
            }
        }
        return removed;
    }

    // Método sincronizado para evitar problemas de concorrência ao escrever no arquivo
    public synchronized void save(Solicitacao novaSolicitacao) {
        List<Solicitacao> solicitacoes = new ArrayList<>(findAll());

        // Gera um novo ID baseado no maior ID existente
        long nextId = solicitacoes.stream()
                .mapToLong(Solicitacao::id)
                .max()
                .orElse(0L) + 1;

        // Cria um novo registro com o ID gerado
        Solicitacao solicitacaoParaSalvar = new Solicitacao(
                nextId,
                novaSolicitacao.solicitante(),
                novaSolicitacao.equipamento(),
                novaSolicitacao.setor(),
                novaSolicitacao.data(),
                novaSolicitacao.descricaoProblema(),
                novaSolicitacao.categoria(), /// novas adicoes aq
                novaSolicitacao.prazo(),
                novaSolicitacao.observacoes(),
                novaSolicitacao.anexoUrl()
        );

        solicitacoes.add(solicitacaoParaSalvar);

        try {
            // Escreve a lista inteira de volta no arquivo JSON
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), solicitacoes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}