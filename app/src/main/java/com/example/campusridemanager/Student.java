package com.example.campusridemanager;
public class Student {
    private int id;
    private String name;
    private String hostel;
    private String vehicleNumber;
    private String hologramNumber;
    private String password;

    // Constructor
    public Student(String name, String hostel, String vehicleNumber, String hologramNumber, String password) {
        this.name = name;
        this.hostel = hostel;
        this.vehicleNumber = vehicleNumber;
        this.hologramNumber = hologramNumber;
        this.password = password;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHostel() {
        return hostel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getHologramNumber() {
        return hologramNumber;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setHologramNumber(String hologramNumber) {
        this.hologramNumber = hologramNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
