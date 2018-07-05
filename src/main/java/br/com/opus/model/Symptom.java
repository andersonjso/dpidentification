package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andersonjso on 3/12/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Symptom {

    private enum Type {SMELL, QUALITY_ATTRIBUTE}

    private int id;
    private Element element;
    private String type;
    private String value;
    private String description;
    private Relation[] relation;
    private String reason;

    public Symptom(@JsonProperty("id") int id,
                   @JsonProperty("element") Element element,
                   @JsonProperty("type") String type,
                   @JsonProperty("value") String value,
                   @JsonProperty("description") String description,
                   @JsonProperty("relation") Relation[] relation,
                   @JsonProperty("reason") String reason) {
        this.id = id;
        this.element = element;
        this.type = type;
        this.value = value;
        this.description = description;
        this.relation = relation;
        this.reason = reason;
    }

    public Symptom(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }
}
