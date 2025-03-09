/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mainactivity.mavenproject6.resources;

/**
 *
 * @author Dewmi
 */
import db.DBUtils;
import db.Distance;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("distances")
public class DistanceService {
    private final DBUtils dbUtils = new DBUtils();
    private final Gson gson = new Gson();

    // Get all distances
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDistances() {
        List<Distance> distances = dbUtils.getAllDistances();
        return Response.status(200).entity(gson.toJson(distances)).build();
    }

    // Get a distance by ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDistanceById(@PathParam("id") int id) {
        Distance distance = dbUtils.getDistanceById(id);
        if (distance == null) {
            return Response.status(404).entity("Distance not found").build();
        } else {
            return Response.status(200).entity(gson.toJson(distance)).build();
        }
    }

    // Add a new distance
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDistance(String json) {
        Distance distance = gson.fromJson(json, Distance.class);
        boolean res = dbUtils.addDistance(distance);

        if (res) {
            return Response.status(201).entity("Distance added successfully").build();
        } else {
            return Response.status(500).entity("Error adding distance").build();
        }
    }

    // Update an existing distance
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDistance(String json) {
        Distance distance = gson.fromJson(json, Distance.class);
        boolean res = dbUtils.updateDistance(distance);

        if (res) {
            return Response.status(200).entity("Distance updated successfully").build();
        } else {
            return Response.status(500).entity("Error updating distance").build();
        }
    }

    // Delete a distance by ID
    @DELETE
    @Path("{id}")
    public Response deleteDistance(@PathParam("id") int id) {
        boolean res = dbUtils.deleteDistance(id);
        if (res) {
            return Response.status(200).entity("Distance deleted successfully").build();
        } else {
            return Response.status(500).entity("Error deleting distance").build();
        }
    }
}