package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andersonjso on 3/12/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Element {

    private enum Type {
        METHOD ("method"),
        CLASS("class");

        private final String name;

        Type(String name){
            this.name = name;
        }
    };

    private String type;
    private String name;
    private int lineStart;
    private int lineEnd;

    @JsonCreator
    public Element (@JsonProperty("type") String type,
                    @JsonProperty("name") String name,
                    @JsonProperty("lineStart") int lineStart,
                    @JsonProperty("lineEnd") int lineEnd){
        this.type = type;
        this.name = name;
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
    }
}

