package br.com.opus.controller;

import br.com.opus.DTO.SymptomDTO;
import br.com.opus.model.Document;
import br.com.opus.model.Symptom;
import br.com.opus.service.SymptomService;
import com.google.gson.Gson;
import org.jooby.Result;
import org.jooby.Results;
import org.jooby.mvc.Body;
import org.jooby.mvc.GET;
import org.jooby.mvc.PUT;
import org.jooby.mvc.Path;

import java.util.Arrays;
import java.util.List;

public class SymptomController {

    SymptomService symptomService = new SymptomService();
    private Gson gson = new Gson();

    @GET
    @Path("/symptoms")
    public Result listSymptoms(){

        List<Symptom> symptoms = symptomService.listSymptoms();

        return Results.json(gson.toJson(symptoms));
    }

    @GET
    @Path("/symptoms/type")
    public Result groupSymptomsByType(){

        List<SymptomDTO> symptoms = symptomService.groupSymptomsByType();


        return Results.json(gson.toJson(symptoms));
    }
}
