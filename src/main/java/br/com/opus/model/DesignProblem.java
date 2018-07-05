package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DesignProblem {


    private String name;
    private String description;
    private List<SetSymptoms> setSymptoms;

    public DesignProblem(@JsonProperty("name") String name,
                         @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
        this.setSymptoms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SetSymptoms> getSetSymptoms() {
        return setSymptoms;
    }

    public void setSetSymptoms(List<SetSymptoms> setSymptoms) {
        this.setSymptoms = setSymptoms;
    }
}


