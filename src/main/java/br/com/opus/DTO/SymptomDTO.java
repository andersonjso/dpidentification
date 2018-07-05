package br.com.opus.DTO;

import br.com.opus.model.Symptom;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SymptomDTO {

    private List<Symptom> symptoms;
    private String typeSymptom;

    public SymptomDTO(@JsonProperty("symptoms") List<Symptom> symptoms,
                      @JsonProperty("type") String typeSymptom) {
        this.symptoms = symptoms;
        this.typeSymptom = typeSymptom;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public String getTypeSymptom() {
        return typeSymptom;
    }

    public void setTypeSymptom(String typeSymptom) {
        this.typeSymptom = typeSymptom;
    }
}