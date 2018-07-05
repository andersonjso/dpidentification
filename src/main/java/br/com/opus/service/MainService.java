package br.com.opus.service;

import br.com.opus.model.Document;
import br.com.opus.model.Symptom;
import br.com.opus.repository.MainRepository;

import java.util.List;

/**
 * Created by andersonjso on 6/28/18.
 */
public class MainService {

    private MainRepository mainRepository = new MainRepository();

    public List<Document> listClasses(List<String> symptomsToExclude) {

        List<Document> classes = mainRepository.listClasses();

        for (Document classDP : classes) {

            classDP.getSyndrome().removeIf(symptom -> symptomsToExclude.contains(symptom.getType()));
        }

        return classes;
    }

    public Document getClassDP(String name) {
        return mainRepository.getClassDP(name);
    }
}
