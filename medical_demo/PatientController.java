package com.lidia_tomus.medical_site.medical_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/patients")
    public String patientList(Model model) {
        logger.info("Fetching patient list");
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        model.addAttribute("diseases", diseaseService.getAllDiseases());
        return "patients";
    }

    @PostMapping("/patients/add-prescription")
    public String addPrescriptionToPatient(@RequestParam String patientName, @RequestParam String medicationName, @RequestParam String dosage) {
        logger.info("Adding prescription to patient with name: {}", patientName);
        Patient patient = patientService.getPatientByName(patientName);
        if (patient != null) {
            Doctor doctor = new Doctor(1L, "Dr. John Doe", new Department(1L, "Cardiology")); // Example doctor
            Prescription prescription = new Prescription(medicationName, dosage, doctor, patient);
            patientService.addPrescriptionToPatient(patient.getId(), prescription);
            logger.info("Prescription added to patient: {}", patientName);
        } else {
            logger.error("Patient not found: {}", patientName);
        }
        return "redirect:/patients";
    }


    @PostMapping("/patients/{patientId}/add-disease")
    public String addDiseaseToPatient(@PathVariable Long patientId, @RequestParam String diseaseName) {
        logger.info("Adding disease to patient with ID: {}", patientId);
        Disease disease = diseaseService.getAllDiseases().stream()
                .filter(d -> d.getName().equals(diseaseName))
                .findFirst()
                .orElse(null);
        if (disease != null) {
            patientService.addDiseaseToPatient(patientId, disease);
        } else {
            logger.warn("Disease with name: {} not found", diseaseName);
        }
        return "redirect:/patients";
    }

    @PostMapping("/patients/add")
    public String addPatient(@RequestParam String name, @RequestParam int age, @RequestParam String disease) {
        Patient patient = new Patient(name, age);
        Disease diseaseEntity = diseaseService.getAllDiseases().stream()
                .filter(d -> d.getName().equals(disease))
                .findFirst()
                .orElse(null);
        if (diseaseEntity != null) {
            patient.getDiseases().add(diseaseEntity);
        }
        patientService.addPatient(patient);
        return "redirect:/patients";
    }

    @PostMapping("/patients/{patientId}/delete")
    public String deletePatient(@PathVariable Long patientId) {
        logger.info("Deleting patient with ID: {}", patientId);
        patientService.deletePatient(patientId);
        return "redirect:/patients";
    }
}