package com.lidia_tomus.medical_site.medical_demo;


public class InfectiousDisease extends Disease {
    private String transmissionMode;
    private boolean isVaccinatable;

    public InfectiousDisease(String name, String symptoms, String prevention, String transmissionMode, boolean isVaccinatable) {
        super(name, symptoms, prevention);
        this.transmissionMode = transmissionMode;
        this.isVaccinatable = isVaccinatable;
    }

    public String getTransmissionMode() {
        return transmissionMode;
    }

    public void setTransmissionMode(String transmissionMode) {
        this.transmissionMode = transmissionMode;
    }

    public boolean isVaccinatable() {
        return isVaccinatable;
    }

    public void setVaccinatable(boolean isVaccinatable) {
        this.isVaccinatable = isVaccinatable;
    }
}
