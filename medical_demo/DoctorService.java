package com.lidia_tomus.medical_site.medical_demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();
    public DoctorService() {
        Department cardiology = new Department(1L, "Cardiology");
        Department orthopedics = new Department(2L, "Orthopedics");
        Department neurology = new Department(3L, "Neurology");
        Department pediatrics = new Department(4L, "Pediatrics");

        Doctor doctor1 = new Doctor(1L, "Dr. John Doe", cardiology);
        Doctor doctor2 = new Doctor(2L, "Dr. Jane Smith", orthopedics);
        Doctor doctor3 = new Doctor(3L, "Dr. Emily Johnson", neurology);
        Doctor doctor4 = new Doctor(4L, "Dr. Michael Brown", pediatrics);

        Patient patient1 = new Patient(1L, "Alice Smith", 25);
        Patient patient2 = new Patient(2L, "John Doe", 40);
        Patient patient3 = new Patient(3L, "Mary Johnson", 30);
        Patient patient4 = new Patient(4L, "James Brown", 50);

        doctor1.getPatients().add(patient1);
        doctor2.getPatients().add(patient2);
        doctor3.getPatients().add(patient3);
        doctor4.getPatients().add(patient4);

        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);
    }
    public void addDoctor(Doctor doctor) {
        doctor.setId(idCounter.incrementAndGet());
        doctors.add(doctor);
    }
    public Doctor getDoctorById(Long id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public void addPatientToDoctor(Long doctorId, Patient patient) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(doctorId)) {
                doctor.getPatients().add(patient);
                break;
            }
        }
    }

    public void removePatientFromDoctor(Long doctorId, Long patientId) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(doctorId)) {
                doctor.getPatients().removeIf(patient -> patient.getId().equals(patientId));
                break;
            }
        }
    }


}