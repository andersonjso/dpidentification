package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andersonjso on 3/12/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceFile {

    private String file;
    private String fullyQualifiedName;
    private String name;

    @JsonCreator
    public SourceFile(@JsonProperty("file") String file,
                      @JsonProperty("fullyQualifiedName") String fullyQualifiedName,
                      @JsonProperty("name") String name) {
        this.file = file;
        this.fullyQualifiedName = fullyQualifiedName;
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    public String getName() {
        return name;
    }
}
