/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author Dewmi
 */


import java.time.LocalDateTime;

public class Distance {
    private int distanceId;
    private String pickupLocation;
    private String dropLocation;
    private double distanceKm;
    private String createdAt;

    // Constructor
    public Distance(int distanceId, String pickupLocation, String dropLocation, double distanceKm, String createdAt) {
        this.distanceId = distanceId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.distanceKm = distanceKm;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getDistanceId() {
        return distanceId;
    }

    public void setDistanceId(int distanceId) {
        this.distanceId = distanceId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}