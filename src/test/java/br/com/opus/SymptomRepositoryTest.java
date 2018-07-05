package br.com.opus;

import br.com.opus.DTO.SymptomDTO;
import br.com.opus.model.Symptom;
import br.com.opus.service.SymptomService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by andersonjso on 7/3/18.
 */
public class SymptomRepositoryTest extends AbstractRepositoryTest {

    SymptomService symptomServiceMock = mock(SymptomService.class);

    @Test
    public void shouldListAllSymptoms(){

        Symptom symptomLM = new Symptom("smell", "Long Method");
        Symptom symptomGC = new Symptom("smell", "God Class");

        List<Symptom> symptoms = new ArrayList<>();
        symptoms.add(symptomGC);
        symptoms.add(symptomLM);

        when(symptomServiceMock.listSymptoms()).thenReturn(symptoms);

        List<Symptom> symptomsRetrieved = symptomServiceMock.listSymptoms();

        assertTrue(symptomsRetrieved.size() == 2);
    }

    @Test
    public void shoulGroupSymptomsByType(){
        Symptom symptomLM = new Symptom("smell", "Long Method");
        Symptom symptomGC = new Symptom("smell", "God Class");

        List<Symptom> symptoms = new ArrayList<>();
        symptoms.add(symptomGC);
        symptoms.add(symptomLM);

        SymptomDTO symptomDTO = new SymptomDTO(symptoms, "smell");

        List<SymptomDTO> listDTOS = new ArrayList<>();
        listDTOS.add(symptomDTO);

        when(symptomServiceMock.groupSymptomsByType()).thenReturn(listDTOS);

        List<SymptomDTO> symptomDTOS = symptomServiceMock.groupSymptomsByType();

        assertTrue(symptomDTOS.size() == 1);
        assertTrue(symptomDTOS.get(0).getTypeSymptom().equals("smell"));
    }

    /*
    public class SymptomDTO {

    private List<Symptom> symptoms;
    private String typeSymptom;

    public SymptomDTO(@JsonProperty("symptoms") List<Symptom> symptoms,
                      @JsonProperty("type") String typeSymptom) {
        this.symptoms = symptoms;
        this.typeSymptom = typeSymptom;
    }
}

     */
}
