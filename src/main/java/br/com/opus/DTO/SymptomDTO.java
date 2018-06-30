package br.com.opus.DTO;

import br.com.opus.model.Symptom;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by andersonjso on 6/29/18.
 */
public class SymptomDTO {

    private List<Symptom> symptoms;
    private String typeSymptom;

    public SymptomDTO(@JsonProperty("symptoms") List<Symptom> symptoms,
                      @JsonProperty("type") String typeSymptom) {
        this.symptoms = symptoms;
        this.typeSymptom = typeSymptom;
    }
}

/*
private SourceCodeData sourceCodeData;
    private List<Symptom> syndrome;

    public DocumentDTO (@JsonProperty("sourceCodeData") SourceCodeData sourceCodeData,
                     @JsonProperty("syndrome") List<Symptom> syndrome){
        this.sourceCodeData = sourceCodeData;
        this.syndrome = syndrome;
    }

    public DocumentDTO(){}

    public void convertDocument(Document document){
        this.sourceCodeData = new SourceCodeData(document.getSourceFile().getFile(),
                document.getSourceFile().getFullyQualifiedName(),
                document.getSourceFile().getName());

        this.syndrome = document.getSyndrome();
    }
 */
