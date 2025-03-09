/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mainactivity.mavenproject6.resources;

import com.google.gson.Gson;
import db.DBUtils;
import db.Driver;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dewmi
 */
@Path("drivers")
public class DriverService {
    private final DBUtils dbUtils = new DBUtils();
    private final Gson gson = new Gson();
    
    // Retrieve all drivers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrivers() {
        List<Driver> drivers = dbUtils.getDrivers();
        return Response.status(200).entity(gson.toJson(drivers)).build();
    }

    // Retrieve a single driver by ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDriver(@PathParam("id") int id) {
        try {
            Driver driver = dbUtils.getDriver(id);
            if (driver == null) {
                return Response.status(404).build();
            } else {
                return Response.status(200).entity(gson.toJson(driver)).build();
            }
        } catch (SQLException e) {
            return Response.status(500).build();
        }
    }

    // Add a new driver
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDriver(String json) {
        Driver driver = gson.fromJson(json, Driver.class);
        boolean res = dbUtils.addDriver(driver);

        if (res) {
            return Response.status(201).build();
        } else {
            return Response.status(500).build();
        }
    }

    // Update an existing driver
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDriver(String json) {
        Driver driver = gson.fromJson(json, Driver.class);
        boolean res = dbUtils.updateDriver(driver);

        if (res) {
            return Response.status(200).build();
        } else {
            return Response.status(500).build();
        }
    }

    // Delete a driver by ID
    @DELETE
    @Path("{id}")
    public Response deleteDriver(@PathParam("id") int id) {
        boolean res = dbUtils.deleteDriver(id);
        if (res) {
            return Response.status(200).build();
        } else {
            return Response.status(500).build();
        }
    }

    // Set driver availability (Available/Unavailable)
    @POST
    @Path("availability/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setDriverAvailability(@PathParam("id") int id, boolean isAvailable) {
        boolean res = dbUtils.setDriverAvailability(id, isAvailable);
        if (res) {
            return Response.status(200).build();
        } else {
            return Response.status(500).build();
        }
    }

    // Get driver availability
    @GET
    @Path("availability/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDriverAvailability(@PathParam("id") int id) {
        boolean availability = dbUtils.getDriverAvailability(id);
        return Response.status(200).entity("{\"availability\":" + availability + "}").build();
    }
}
