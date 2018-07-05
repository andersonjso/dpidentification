package br.com.opus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SetSymptoms{
    private List<Symptom> symptoms;
    private String user;

    public SetSymptoms(@JsonProperty("user") String user) {
        this.symptoms = new ArrayList<>();
        this.user = user;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
