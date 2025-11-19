package com.lidia_tomus.medical_site.medical_demo;

public class Prescription {
    private Long id;
    private String medicationName;
    private String dosage;
    private Doctor doctor;
    private Patient patient;

    public Prescription(Long id, String medicationName, String dosage, Doctor doctor, Patient patient) {
        this.id = id;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Prescription(String medicationName, String dosage, Doctor doctor, Patient patient) {
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}