package com.lidia_tomus.medical_site.medical_demo;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private Long id;
    private String name;
    private int age;
    private List<Doctor> doctors;
    private List<Prescription> prescriptions;
    private List<Disease> diseases;

    public Patient(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doctors = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.diseases = new ArrayList<>();
    }

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
        this.doctors = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.diseases = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
}