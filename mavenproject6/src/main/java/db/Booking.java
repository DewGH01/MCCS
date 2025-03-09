/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
/**
 *
 * @author Dewmi
 */
public class Booking {
    private int bookingId;
    private int userId;
    private String customerName;
    private String email;
    private String pickupLocation;
    private String dropLocation;
    private int driverId;
    private int carId;
    private double pricePerKm;
    private int distanceId;
    private String createdAt;
    private String updatedAt;

    public Booking() {}

    public Booking(int bookingId, int userId, String customerName, String email, String pickupLocation, 
                   String dropLocation, int driverId, int carId, double pricePerKm, int distanceId, 
                   String createdAt, String updatedAt) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.customerName = customerName;
        this.email = email;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.driverId = driverId;
        this.carId = carId;
        this.pricePerKm = pricePerKm;
        this.distanceId = distanceId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and setters
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }

    public String getDropLocation() { return dropLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }

    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }

    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }

    public double getPricePerKm() { return pricePerKm; }
    public void setPricePerKm(double pricePerKm) { this.pricePerKm = pricePerKm; }

    public int getDistanceId() { return distanceId; }
    public void setDistanceId(int distanceId) { this.distanceId = distanceId; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}