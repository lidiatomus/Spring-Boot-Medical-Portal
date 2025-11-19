package com.lidia_tomus.medical_site.medical_demo;

public class SurgicalDepartment extends BaseDepartment {
    private int numberOfOperatingRooms;

    public SurgicalDepartment(Long id, String name, int numberOfOperatingRooms) {
        super(id, name);
        this.numberOfOperatingRooms = numberOfOperatingRooms;
    }

    public int getNumberOfOperatingRooms() {
        return numberOfOperatingRooms;
    }

    public void setNumberOfOperatingRooms(int numberOfOperatingRooms) {
        this.numberOfOperatingRooms = numberOfOperatingRooms;
    }

    @Override
    public String getDetails() {
        return "Number of Operating Rooms: " + numberOfOperatingRooms;
    }
}
