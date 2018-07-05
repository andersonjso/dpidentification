package br.com.opus.controller;

import br.com.opus.model.DesignProblem;
import br.com.opus.model.SetSymptoms;
import br.com.opus.model.Symptom;
import br.com.opus.service.DesignProblemService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jooby.Result;
import org.jooby.Results;
import org.jooby.mvc.Body;
import org.jooby.mvc.GET;
import org.jooby.mvc.PUT;
import org.jooby.mvc.Path;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class DesignProblemController {

    private DesignProblemService designProblemService = new DesignProblemService();
    private Gson gson = new Gson();

    @GET
    @Path("/designproblems")
    public Result listDesignProblems(){
        List<DesignProblem> designProblems = designProblemService.listDesignProblems();

        return Results.json(gson.toJson(designProblems));
    }

    @PUT
    @Path("/designproblem/:dpname/set")
    public Result updateSymptomsExampleWithSet(String dpname, @Body String symptomsList){

        SetSymptoms setSymptomsList = gson.fromJson(symptomsList, SetSymptoms.class);

        DesignProblem dpUpdated = designProblemService.updateDPWithSetExamples(dpname, setSymptomsList);

        return Results.json(gson.toJson(dpUpdated));
    }

}
