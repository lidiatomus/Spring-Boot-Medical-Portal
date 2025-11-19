package com.lidia_tomus.medical_site.medical_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public String departmentList(Model model) {
        List<BaseDepartment> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "departments";
    }
}
