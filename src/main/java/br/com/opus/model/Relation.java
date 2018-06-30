package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andersonjso on 3/12/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Relation {

    private enum Type {AGGLOMERATION, NORMAL};

    private String type;
    private int[] relatedSymptoms;

    @JsonCreator
    public Relation(@JsonProperty("type") String type,
                    @JsonProperty("relatedSymptoms") int[] relatedSymptoms) {
        this.type = type;
        this.relatedSymptoms = relatedSymptoms;
    }
}
