package com.lidia_tomus.medical_site.medical_demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PrescriptionService {
    private List<Prescription> prescriptions = new ArrayList<>();

    public PrescriptionService() {
        Doctor doctor1 = new Doctor(1L, "Dr. John Doe", new Department(1L, "Cardiology"));
        Doctor doctor2 = new Doctor(2L, "Dr. Jane Smith", new Department(2L, "Orthopedics"));
        Patient patient1 = new Patient(1L, "Alice Smith", 25);
        Patient patient2 = new Patient(2L, "John Doe", 40);

        prescriptions.add(new Prescription(1L, "Medication A", "Dosage A", doctor1, patient1));
        prescriptions.add(new Prescription(2L, "Medication B", "Dosage B", doctor2, patient2));
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public Prescription getPrescriptionById(Long id) {
        return prescriptions.stream()
                .filter(prescription -> prescription.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void updatePrescription(Long id, Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).getId().equals(id)) {
                prescriptions.set(i, updatedPrescription);
                return;
            }
        }
    }

    public void deletePrescription(Long id) {
        prescriptions.removeIf(prescription -> prescription.getId().equals(id));
    }
}