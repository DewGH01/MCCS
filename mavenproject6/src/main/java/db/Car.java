/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author Dewmi
 */
public class Car {
    private int carId;
    private String model;
    private String make;
    private int year;
    private double pricePerKm;
    private boolean isAvailable;
    private String createdAt;

    public Car() {}

    public Car(int carId, String model, String make, int year, double pricePerKm, boolean isAvailable, String createdAt) {
        this.carId = carId;
        this.model = model;
        this.make = make;
        this.year = year;
        this.pricePerKm = pricePerKm;
        this.isAvailable = isAvailable;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getCarId() {return carId;}
    public void setCarId(int carId) {this.carId = carId;}
    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}
    public String getMake() {return make;}
    public void setMake(String make) {this.make = make;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
    public double getPricePerKm() {return pricePerKm;}
    public void setPricePerKm(double pricePerKm) {this.pricePerKm = pricePerKm;}
    public boolean isAvailable() {return isAvailable;}
    public void setAvailable(boolean available) {isAvailable = available;}
    public String getCreatedAt() {return createdAt;}
    public void setCreatedAt(String createdAt) {this.createdAt = createdAt;}
}
