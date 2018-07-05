package br.com.opus.controller;

import br.com.opus.service.SnippetService;
import br.com.opus.model.Snippet;
import com.google.gson.Gson;
import org.jooby.Result;
import org.jooby.Results;
import org.jooby.Upload;
import org.jooby.mvc.Body;
import org.jooby.mvc.GET;
import org.jooby.mvc.POST;
import org.jooby.mvc.Path;

import java.util.List;

public class SnippetController {

    SnippetService snippetService = new SnippetService();
    private Gson gson = new Gson();

    @POST
    @Path("/snippets")
    public Result listSymptoms(Upload file){

        String fileID = snippetService.uploadFile(file);

        return Results.json(fileID);
    }

    @POST
    @Path ("snippets/metadata/:id")
    public Result setMetadata(String id, @Body String bodyResponse){

        Snippet snippetData = gson.fromJson(bodyResponse, Snippet.class);
        //
        Snippet snippet = snippetService.setMetadata(id, snippetData);

        return Results.json(gson.toJson(snippet));
    }

    @GET
    @Path("snippets/:value")
    public Result getSnippetsBySymptom(String value){

        List<Snippet> snippets = snippetService.getSnippetsBySymptom(value);

        return Results.json(gson.toJson(snippets));
    }

    @GET
    @Path("snippets/sourcecode/:id")
    public Result retrieveSourceCode(String id) {
        String sourceCode = snippetService.retrieveSourceCode(id);

        return Results.json(gson.toJson(sourceCode));

    }
}
