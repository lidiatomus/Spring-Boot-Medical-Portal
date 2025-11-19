package com.lidia_tomus.medical_site.medical_demo;

import com.lidia_tomus.medical_site.medical_demo.Disease;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiseaseService {
    private List<Disease> diseases = new ArrayList<>();

    public DiseaseService() {
        // Chronic Diseases
        diseases.add(new ChronicDisease("Diabetes", "Increased thirst, frequent urination", "Healthy diet, regular exercise", "Insulin therapy"));
        diseases.add(new ChronicDisease("Hypertension", "Headaches, shortness of breath", "Low salt diet, exercise", "Blood pressure medication"));
        diseases.add(new ChronicDisease("Asthma", "Wheezing, shortness of breath", "Avoid allergens, inhalers", "Asthma control medications"));
        diseases.add(new ChronicDisease("Arthritis", "Joint pain, stiffness", "Physical therapy, anti-inflammatory drugs", "Pain management, physical therapy"));
        diseases.add(new ChronicDisease("Chronic Kidney Disease", "Fatigue, swelling", "Limit salt intake, exercise", "Dialysis, kidney transplant"));

        // Infectious Diseases
        diseases.add(new InfectiousDisease("Flu", "Fever, cough, sore throat", "Vaccination", "Airborne", true));
        diseases.add(new InfectiousDisease("Tuberculosis", "Persistent cough, chest pain", "Good ventilation, vaccination", "Airborne", true));
        diseases.add(new InfectiousDisease("Malaria", "Fever, chills, sweating", "Mosquito nets, antimalarial drugs", "Vector-borne (mosquito)", true));
        diseases.add(new InfectiousDisease("COVID-19", "Fever, dry cough, difficulty breathing", "Vaccination, mask-wearing", "Airborne", true));
        diseases.add(new InfectiousDisease("HIV/AIDS", "Chronic fever, weight loss", "Safe sex, antiretroviral therapy", "Bloodborne, sexual contact", true));
    }

    public List<Disease> filterDiseasesByName(List<Disease> diseases, String name) {
        return diseases.stream()
                .filter(disease -> disease.getName().toLowerCase().contains(name.toLowerCase())) // Adjust this to your disease property
                .collect(Collectors.toList());
    }


    // Add a disease to the list
    public void addDisease(Disease disease) {
        diseases.add(disease);
    }

    // Get all diseases
    public List<Disease> getAllDiseases() {
        return diseases;
    }

    // Get diseases filtered by their class type
    public List<Disease> getDiseasesByType(Class<? extends Disease> type) {
        return diseases.stream()
                .filter(disease -> type.isInstance(disease))
                .collect(Collectors.toList());
    }


}
