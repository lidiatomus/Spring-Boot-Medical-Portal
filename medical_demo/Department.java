package com.lidia_tomus.medical_site.medical_demo;

public class Department extends BaseDepartment {

    public Department(Long id, String name) {
        super(id, name);
    }

    @Override
    public String getDetails() {
        return "General Department";
    }
}
