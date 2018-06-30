package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

/**
 * Created by andersonjso on 6/29/18.
 */
public class Snippet {

    private String userName;
    private String fileName;
    private String description;
    private ObjectId idSourceFile;

    public Snippet(@JsonProperty("userName") String userName,
                   @JsonProperty("fileName") String fileName,
                   @JsonProperty("description") String description,
                   @JsonProperty("idSourceFile") ObjectId idSourceFile) {
        this.userName = userName;
        this.fileName = fileName;
        this.description = description;
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

    public ObjectId getIdSourceFile() {
        return idSourceFile;
    }

    public void setIdSourceFile(ObjectId idSourceFile) {
        this.idSourceFile = idSourceFile;
    }
}
