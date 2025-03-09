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
import db.User;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("users")
public class UserService {

    private final DBUtils dbUtils = new DBUtils();
    private final Gson gson = new Gson();

    // Retrieve all users
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> users = dbUtils.getUsers();
        return Response.status(200).entity(gson.toJson(users)).build();
    }

    // Retrieve a single user by ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        User user = dbUtils.getUser(id);
        if (user == null) {
            return Response.status(404).entity("User not found").build();
        } else {
            return Response.status(200).entity(gson.toJson(user)).build();
        }
    }

    // Add a new user (Registration)
    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(String json) {
        User user = gson.fromJson(json, User.class);
        boolean res = dbUtils.addUser(user);

        if (res) {
            return Response.status(201).entity("User registered successfully").build();
        } else {
            return Response.status(500).entity("Error registering user").build();
        }
    }

    // User login
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUser(String json) {
        User user = gson.fromJson(json, User.class);
        boolean isValidUser = dbUtils.loginUser(user.getEmail(), user.getPassword());

        if (isValidUser) {
            return Response.status(200).entity("Login successful").build();
        } else {
            return Response.status(401).entity("Invalid email or password").build();
        }
    }

    // Update an existing user
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(String json) {
        User user = gson.fromJson(json, User.class);
        boolean res = dbUtils.updateUser(user);

        if (res) {
            return Response.status(200).entity("User updated successfully").build();
        } else {
            return Response.status(500).entity("Error updating user").build();
        }
    }

    // Delete a user by ID
    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        boolean res = dbUtils.deleteUser(id);
        if (res) {
            return Response.status(200).entity("User deleted successfully").build();
        } else {
            return Response.status(500).entity("Error deleting user").build();
        }
    }
}