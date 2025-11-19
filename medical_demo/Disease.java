package com.lidia_tomus.medical_site.medical_demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Disease {
    private String name;
    private String symptoms;
    private String prevention;

    public Disease(String name, String symptoms, String prevention) {
        this.name = name;
        this.symptoms = symptoms;
        this.prevention = prevention;
    }


    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }


}
