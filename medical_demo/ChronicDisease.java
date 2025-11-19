package com.lidia_tomus.medical_site.medical_demo;


public class ChronicDisease extends Disease {
    private String managementPlan;

    public ChronicDisease(String name, String symptoms, String prevention, String managementPlan) {
        super(name, symptoms, prevention);
        this.managementPlan = managementPlan;
    }

    public String getManagementPlan() {
        return managementPlan;
    }

    public void setManagementPlan(String managementPlan) {
        this.managementPlan = managementPlan;
    }
}
