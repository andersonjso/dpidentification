package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by andersonjso on 3/12/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {

    private SourceFile sourceFile;
    private List<Symptom> syndrome;

    public Document (@JsonProperty("sourceFile") SourceFile sourceFile,
                     @JsonProperty("syndrome") List<Symptom> syndrome){
        this.sourceFile = sourceFile;
        this.syndrome = syndrome;
    }

    public Document(){}

    public SourceFile getSourceFile() {
        return sourceFile;
    }

    public List<Symptom> getSyndrome() {
        return syndrome;
    }
}
