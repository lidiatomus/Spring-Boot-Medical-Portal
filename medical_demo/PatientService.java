package com.lidia_tomus.medical_site.medical_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    private List<Patient> patients = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    public PatientService() {
        Disease diabetes = new ChronicDisease("Diabetes", "Increased thirst, frequent urination", "Healthy diet, regular exercise", "Insulin therapy");
        Disease flu = new InfectiousDisease("Flu", "Fever, cough, sore throat", "Vaccination", "Airborne", true);
        Disease disease3 = new Disease( "Hypertension", "High blood pressure", "Regular exercise");
        Disease disease4 = new Disease( "Asthma", "Shortness of breath", "Inhalers");
        Disease disease5 = new Disease("Chickenpox", "Rash, Fever", "Vaccination");

        Doctor doctor1 = new Doctor(1L, "Dr. John Doe", new Department(1L, "Cardiology"));
        Doctor doctor2 = new Doctor(2L, "Dr. Jane Smith", new Department(2L, "Orthopedics"));
        Doctor doctor3 = new Doctor(3L, "Dr. Emily Johnson", new Department(3L, "Neurology"));
        Doctor doctor4 = new Doctor(4L, "Dr. Michael Brown", new Department(4L, "Pediatrics"));
        Doctor doctor5 = new Doctor(5L, "Dr. Sarah Davis", new Department(5L, "Dermatology"));


        Patient patient1 = new Patient(1L, "Alice Smith", 25);
        patient1.getDoctors().add(doctor1);
        patient1.getDiseases().add(diabetes);
        patient1.getPrescriptions().add(new Prescription(1L, "Medication A", "Dosage A", doctor1, patient1));

        Patient patient2 = new Patient(2L, "John Doe", 40);
        patient2.getDoctors().add(doctor2);
        patient2.getDiseases().add(flu);
        patient2.getPrescriptions().add(new Prescription(2L, "Medication B", "Dosage B", doctor2, patient2));

        Patient patient3 = new Patient(3L, "Mary Johnson", 30);
        patient3.getDoctors().add(doctor3);
        patient3.getDiseases().add(disease3);
        patient3.getPrescriptions().add(new Prescription(3L, "Medication C", "Dosage C", doctor3, patient3));

        Patient patient4 = new Patient(4L, "James Brown", 50);
        patient4.getDoctors().add(doctor4);
        patient4.getDiseases().add(disease4);
        patient4.getPrescriptions().add(new Prescription(4L, "Medication D", "Dosage D", doctor4, patient4));

        Patient patient5 = new Patient(5L, "Emma Wilson", 35);
        patient5.getDoctors().add(doctor5);
        patient5.getDiseases().add(disease5);
        patient5.getPrescriptions().add(new Prescription(5L, "Medication E", "Dosage E", doctor5, patient5));

        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);
        patients.add(patient5);;
    }
    public Patient getPatientByName(String name) {
        logger.info("Retrieving patient with name: {}", name);
        return patients.stream()
                .filter(patient -> patient.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Patient> getAllPatients() {
        logger.info("Retrieving all patients");
        return patients;
    }

    public void addPrescriptionToPatient(Long patientId, Prescription prescription) {
        logger.info("Adding prescription to patient with ID: {}", patientId);
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                patient.getPrescriptions().add(prescription);
                logger.info("Prescription added to patient: {}", patient.getName());
                break;
            }
        }
    }

    public void addDiseaseToPatient(Long patientId, Disease disease) {
        logger.info("Adding disease to patient with ID: {}", patientId);
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                patient.getDiseases().add(disease);
                logger.info("Disease added to patient: {}", patient.getName());
                break;
            }
        }
    }

    public Patient getPatientById(Long patientId) {
        logger.info("Retrieving patient with ID: {}", patientId);
        return patients.stream()
                .filter(patient -> patient.getId().equals(patientId))
                .findFirst()
                .orElse(null);
    }

    public void addPatient(Patient patient) {
        patient.setId(idCounter.incrementAndGet());
        patients.add(patient);
    }

    public void deletePatient(Long patientId) {
        logger.info("Deleting patient with ID: {}", patientId);
        patients.removeIf(patient -> patient.getId().equals(patientId));
    }
}