package br.com.opus.controller;

import br.com.opus.model.Document;
import br.com.opus.DTO.DocumentDTO;
import br.com.opus.repository.MainRepository;
import br.com.opus.service.MainService;
import com.google.gson.Gson;
import org.jooby.Result;
import org.jooby.Results;
import org.jooby.mvc.Body;
import org.jooby.mvc.GET;
import org.jooby.mvc.PUT;
import org.jooby.mvc.Path;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andersonjso on 3/12/18.
 */
public class MainController {

    private MainRepository mainRepository = new MainRepository();
    private MainService mainService = new MainService();
    private Gson gson = new Gson();

    @GET
    @Path("/start")
    public Result justATest(){
        return Results.ok("oi time");
    }

    @GET
    @Path("/convert")
    public Result convert(){
        List<DocumentDTO> documentsOutput = new ArrayList<>();
        String jsonInString = "";
        try {
            Document[] documents = gson.fromJson(
                    new FileReader("/Users/andersonjso/Documents/development/experiment-dp/src/main/java/br/com/opus/resources/symptoms-short.json"),
                    Document[].class);





            for (int i =0; i<documents.length; i++){
                DocumentDTO documentDTO = new DocumentDTO();

                documentDTO.convertDocument(documents[i]);

                documentsOutput.add(documentDTO);
            }

            jsonInString = gson.toJson(documentsOutput);

           // System.out.println(jsonInString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        return Results.json(jsonInString);
    }

    @PUT
    @Path("/classes")
    public Result listClasses(@Body String symptomsToExclude){
        List<String> items = Arrays.asList(symptomsToExclude.split("\\s*,\\s*"));

        List<Document> classes = mainService.listClasses(items);

        return Results.json(gson.toJson(classes));
    }
}



//    @GET
//    @Path("/nodule/similar")
//    public Result retrieveSimilarNodules(@Named("dbPath") Optional<String> dbPath,
//                                         @Named("folder") Optional<String> folder){
//        List<SimilarNodule> similarNodules = new ArrayList<>();
////        try {
//        if (dbPath.isPresent()){
//            similarNodules = cadService.retrieveSimilarNodulesByPath(dbPath.get());
//        }
//        else if (folder.isPresent()){
//            // similarNodules = CADService.retrieveSimilarNodulesByFolder(folder.get());
//        }
//        return Results.ok(mapper.toJson(similarNodules));
////        } catch (UnknownHostException e) {
////            return Results.with(400);
////        }
//    }