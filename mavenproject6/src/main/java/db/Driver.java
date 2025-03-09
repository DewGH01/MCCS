/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author Dewmi
 */
public class Driver {
     private int driverId;
    private String driverName;
    private String driverPhone;
    private boolean availability;
    private String driverLicense;
    private String createdAt;

    public Driver() {}

    public Driver(int driverId, String driverName, String driverPhone, boolean availability, String driverLicense, String createdAt) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverPhone = driverPhone;
        this.availability = availability;
        this.driverLicense = driverLicense;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public String getDriverPhone() { return driverPhone; }
    public void setDriverPhone(String driverPhone) { this.driverPhone = driverPhone; }
    public boolean isAvailability() { return availability; }
    public void setAvailability(boolean availability) { this.availability = availability; }
    public String getDriverLicense() { return driverLicense; }
    public void setDriverLicense(String driverLicense) { this.driverLicense = driverLicense; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
