/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mainactivity.mavenproject6.resources;


import com.google.gson.Gson;
import db.Car;
import db.DBUtils;
import java.sql.SQLException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
/**
 *
 * @author Dewmi
 */
@Path("cars")
public class CarService {
    private final DBUtils dbUtils = new DBUtils();
    private final Gson gson = new Gson();
    
    // Retrieve all cars
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCars() {
        List<Car> cars = dbUtils.getCars();
        return Response.status(200).entity(gson.toJson(cars)).build();
    }
    
    // Retrieve a car by ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCar(@PathParam("id") int id) {
        try {
            Car car = dbUtils.getCar(id);
            if (car == null) {
                return Response.status(404).build();
            } else {
                return Response.status(200).entity(gson.toJson(car)).build();
            }
        } catch (SQLException e) {
            return Response.status(500).build();
        }
    }
    
    // Add a new car
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCar(String json) {
        Car car = gson.fromJson(json, Car.class);
        boolean res = dbUtils.addCar(car);

        if (res) {
            return Response.status(201).build();
        } else {
            return Response.status(500).build();
        }
    }
    
    // Update an existing car
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCar(String json) {
        Car car = gson.fromJson(json, Car.class);
        boolean res = dbUtils.updateCar(car);

        if (res) {
            return Response.status(200).build();
        } else {
            return Response.status(500).build();
        }
    }
    
    // Delete a car by ID
    @DELETE
    @Path("{id}")
    public Response deleteCar(@PathParam("id") int id) {
        boolean res = dbUtils.deleteCar(id);
        if (res) {
            return Response.status(200).build();
        } else {
            return Response.status(500).build();
        }
    }
    
    // Set car availability (Available/Unavailable)
    @PUT
    @Path("{id}/availability")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setCarAvailability(@PathParam("id") int id, String json) {
        boolean isAvailable = Boolean.parseBoolean(json);
        boolean res = dbUtils.setCarAvailability(id, isAvailable);

        if (res) {
            return Response.status(200).build();
        } else {
            return Response.status(500).build();
        }
    }
    
    // Get cars by availability
    @GET
    @Path("availability/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarsByAvailability(@PathParam("status") boolean status) {
        List<Car> cars = dbUtils.getCarsByAvailability(status);
        return Response.status(200).entity(gson.toJson(cars)).build();
    }
    
    // Get cars by make and model
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarsByMakeAndModel(@QueryParam("make") String make, @QueryParam("model") String model) {
        List<Car> cars = dbUtils.getCarsByMakeAndModel(make, model);
        return Response.status(200).entity(gson.toJson(cars)).build();
    }

}
