package com.lidia_tomus.medical_site.medical_demo;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private Long id;
    private String name;
    private Department department;
    private List<Patient> patients;

    public Doctor(Long id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.patients = new ArrayList<>();
    }

    public Doctor(long id, String name, String cardiology) {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}