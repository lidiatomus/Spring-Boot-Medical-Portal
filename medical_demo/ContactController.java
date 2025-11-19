// src/main/java/com/lidia_tomus/medical_site/medical_demo/ContactController.java
package com.lidia_tomus.medical_site.medical_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}