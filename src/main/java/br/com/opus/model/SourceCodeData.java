package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by andersonjso on 3/13/18.
 */
public class SourceCodeData {

    private String sourceCode;
    private String fullyQualifiedName;
    private String name;

    @JsonCreator
    public SourceCodeData(@JsonProperty("sourceCode") String sourceCode,
                      @JsonProperty("fullyQualifiedName") String fullyQualifiedName,
                      @JsonProperty("name") String name) {
        setSourceCode(sourceCode);
        this.fullyQualifiedName = fullyQualifiedName;
        this.name = name;
    }

    public void setSourceCode(String path) {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("File " + path + " not found");
            e.printStackTrace();
        }
        this.sourceCode = new String(encoded, StandardCharsets.UTF_8);
    }

    public void setFullyQualifiedName(String fullyQualifiedName) {
        this.fullyQualifiedName = fullyQualifiedName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
