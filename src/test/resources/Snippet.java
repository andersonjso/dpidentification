package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andersonjso on 6/29/18.
 */
public class Snippet {

    private String userName;
    private String fileName;
    private String description;
    private Symptom symptom;
    private String idSourceFile;

    public Snippet(@JsonProperty("userName") String userName,
                   @JsonProperty("fileName") String fileName,
                   @JsonProperty("description") String description,
                   @JsonProperty("symptom") Symptom symptom,
                   @JsonProperty("idSourceFile") String idSourceFile) {
        this.userName = userName;
        this.fileName = fileName;
        this.description = description;
        this.symptom = symptom;
        this.idSourceFile = idSourceFile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdSourceFile() {
        return idSourceFile;
    }

    public void setIdSourceFile(String idSourceFile) {
        this.idSourceFile = idSourceFile;
    }
}
