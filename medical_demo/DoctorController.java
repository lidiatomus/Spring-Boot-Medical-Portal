package com.lidia_tomus.medical_site.medical_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

    @GetMapping("/doctors")
    public String doctorList(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);
        return "doctors";
    }

    @PostMapping("/doctors/add")
    public String addDoctor(@RequestParam String name, @RequestParam String department) {
        Department dept = new Department(null, department);
        Doctor doctor = new Doctor(null, name, dept);
        doctorService.addDoctor(doctor);
        return "redirect:/doctors";
    }

    @PostMapping("/doctors/{doctorId}/add-patient")
    public String addPatientToDoctor(@RequestParam Long patientId, @PathVariable Long doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        Patient patient = patientService.getPatientById(patientId);
        if (doctor != null && patient != null) {
            doctorService.addPatientToDoctor(doctorId, patient);
            logger.info("Added patient {} to doctor {}", patient.getName(), doctor.getName());
        } else {
            logger.error("Doctor or patient not found");
        }
        return "redirect:/doctors";
    }

    @PostMapping("/doctors/appoint-doctor")
    public String appointDoctorToPatient(@RequestParam Long doctorId, @RequestParam Long patientId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        Patient patient = patientService.getPatientById(patientId);
        if (doctor != null && patient != null) {
            doctorService.addPatientToDoctor(doctorId, patient);
            logger.info("Appointed doctor {} to patient {}", doctor.getName(), patient.getName());
        } else {
            logger.error("Doctor or patient not found");
        }
        return "redirect:/doctors";
    }
    @PostMapping("/doctors/{doctorId}/remove-patient")
    public String removePatientFromDoctor(@RequestParam Long patientId, @PathVariable Long doctorId) {
        doctorService.removePatientFromDoctor(doctorId, patientId);
        return "redirect:/doctors";
    }
}