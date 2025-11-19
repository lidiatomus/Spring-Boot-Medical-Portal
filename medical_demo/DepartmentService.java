package com.lidia_tomus.medical_site.medical_demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private List<BaseDepartment> departments;

    public DepartmentService() {
        departments = new ArrayList<>();
        departments.add(new SurgicalDepartment(1L, "Surgical Department", 5));
        departments.add(new DiagnosticDepartment(2L, "Diagnostic Department", 10));
        departments.add(new Department(3L, "General Medicine Department"));
    }

    public List<BaseDepartment> getAllDepartments() {
        return departments;
    }
}
