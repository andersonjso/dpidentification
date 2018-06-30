package br.com.opus.service;

import br.com.opus.DTO.SymptomDTO;
import br.com.opus.model.Document;
import br.com.opus.model.Symptom;
import br.com.opus.repository.SymptomRepository;

import java.util.List;

/**
 * Created by andersonjso on 6/29/18.
 */
public class SymptomService {

    SymptomRepository symptomRepository = new SymptomRepository();

    public List<Symptom> listSymptoms() {

        return symptomRepository.listSymptoms();

    }

    public List<SymptomDTO> groupSymptomsByType(){
        return symptomRepository.groupSymptomsByType();
    }
}
