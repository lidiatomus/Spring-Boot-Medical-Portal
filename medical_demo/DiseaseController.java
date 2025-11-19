package com.lidia_tomus.medical_site.medical_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/disease")
    public String diseaseList(Model model) {
        List<Disease> diseases = diseaseService.getAllDiseases();
        diseases.forEach(System.out::println); // Log to console
        model.addAttribute("diseases", diseases);
        return "disease";
    }

    @GetMapping("/diseases")
    @ResponseBody
    public List<Disease> getDiseasesByType(@RequestParam String type) {
        if ("chronic".equals(type)) {
            return diseaseService.getDiseasesByType(ChronicDisease.class);
        } else if ("infectious".equals(type)) {
            return diseaseService.getDiseasesByType(InfectiousDisease.class);
        } else {
            return diseaseService.getAllDiseases(); // Return all diseases for the "all" option
        }
    }

    @PostMapping("/diseases")
    public String addDisease(
            @RequestParam String name,
            @RequestParam String type,
            @RequestParam String symptoms,
            @RequestParam String prevention,
            @RequestParam(required = false) String transmissionMode,
            @RequestParam(required = false) Boolean isVaccinatable,
            @RequestParam(required = false) String managementPlan) {

        if ("chronic".equals(type)) {
            ChronicDisease chronicDisease = new ChronicDisease(name, symptoms, prevention, managementPlan);
            diseaseService.addDisease(chronicDisease);
        } else if ("infectious".equals(type)) {
            InfectiousDisease infectiousDisease = new InfectiousDisease(name, symptoms, prevention, transmissionMode, isVaccinatable);
            diseaseService.addDisease(infectiousDisease);
        }
        return "redirect:/disease"; // Redirect to the disease list page after adding
    }
    @PostMapping("/assignDiseaseToPatient")
    public String assignDiseaseToPatient(@RequestParam Long patientId, @RequestParam String diseaseName) {
        Disease disease = diseaseService.getAllDiseases()
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase(diseaseName))
                .findFirst()
                .orElse(null);

        if (disease != null) {
            patientService.addDiseaseToPatient(patientId, disease);
        }
        return "redirect:/patients"; // Redirect to the patient list page
    }

}