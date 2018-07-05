package br.com.opus.service;

import br.com.opus.model.Snippet;
import br.com.opus.repository.SnippetRepository;
import com.google.gson.Gson;
import org.jooby.Upload;

import java.util.List;

/**
 * Created by andersonjso on 6/29/18.
 */
public class SnippetService {

    SnippetRepository snippetRepository = new SnippetRepository();


    public String uploadFile(Upload file) {
        return snippetRepository.uploadFile(file);
    }

    public Snippet setMetadata(String id, Snippet snippetData) {
        return snippetRepository.setMetadata(id, snippetData);
    }

    public List<Snippet> getSnippetsBySymptom(String value) {
        return snippetRepository.getSnippetsBySymptom(value);
    }

    public String retrieveSourceCode(String id) {
        return snippetRepository.retrieveSourceCode(id);
    }
}
