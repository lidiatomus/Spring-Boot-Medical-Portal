package com.lidia_tomus.medical_site.medical_demo;

public abstract class BaseDepartment {
    private Long id;
    private String name;

    public BaseDepartment(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public abstract String getDetails();
}
