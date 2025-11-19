package com.lidia_tomus.medical_site.medical_demo;

public class DiagnosticDepartment extends BaseDepartment {
    private int numberOfDiagnosticMachines;

    public DiagnosticDepartment(Long id, String name, int numberOfDiagnosticMachines) {
        super(id, name);
        this.numberOfDiagnosticMachines = numberOfDiagnosticMachines;
    }

    public int getNumberOfDiagnosticMachines() {
        return numberOfDiagnosticMachines;
    }

    public void setNumberOfDiagnosticMachines(int numberOfDiagnosticMachines) {
        this.numberOfDiagnosticMachines = numberOfDiagnosticMachines;
    }

    @Override
    public String getDetails() {
        return "Number of Diagnostic Machines: " + numberOfDiagnosticMachines;
    }
}
