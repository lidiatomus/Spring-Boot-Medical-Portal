package com.lidia_tomus.medical_site.medical_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/prescriptions")
    public String prescriptionList(Model model) {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        model.addAttribute("prescriptions", prescriptions);
        return "prescriptions";
    }

    @PostMapping("/prescriptions/add")
    public String addPrescription(@RequestParam String medicationName, @RequestParam String dosage, @RequestParam Long doctorId, @RequestParam Long patientId) {
        Doctor doctor = new Doctor(doctorId, null, null);
        Patient patient = new Patient(patientId, null, 0);
        Prescription prescription = new Prescription(medicationName, dosage, doctor, patient);
        prescriptionService.addPrescription(prescription);
        return "redirect:/prescriptions";
    }


    @GetMapping("/prescriptions/{id}")
    public String getPrescription(@PathVariable Long id, Model model) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        model.addAttribute("prescription", prescription);
        return "prescription-detail";
    }

    @PostMapping("/prescriptions/{id}/update")
    public String updatePrescription(@PathVariable Long id, @RequestParam String medicationName, @RequestParam String dosage) {
        Prescription updatedPrescription = new Prescription(id, medicationName, dosage, null, null);
        prescriptionService.updatePrescription(id, updatedPrescription);
        return "redirect:/prescriptions";
    }

    @PostMapping("/prescriptions/{id}/delete")
    public String deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return "redirect:/prescriptions";
    }
}