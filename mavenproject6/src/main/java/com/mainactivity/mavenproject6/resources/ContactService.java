/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mainactivity.mavenproject6.resources;

/**
 *
 * @author Dewmi
 */
import com.google.gson.Gson;
import db.Contact;
import db.DBUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("contactus")
public class ContactService {
    private final DBUtils dbUtils = new DBUtils();
    private final Gson gson = new Gson();

    // Retrieve all contact messages
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactMessages() {
        List<Contact> contacts = dbUtils.getContactMessages();
        return Response.status(200).entity(gson.toJson(contacts)).build();
    }

    // Retrieve a single contact message by ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContact(@PathParam("id") int id) {
        Contact contact = dbUtils.getContactById(id);
        if (contact == null) {
            return Response.status(404).entity("Contact message not found").build();
        } else {
            return Response.status(200).entity(gson.toJson(contact)).build();
        }
    }

    // Add a new contact message
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContactMessage(String json) {
        Contact contact = gson.fromJson(json, Contact.class);
        boolean res = dbUtils.addContactMessage(contact);

        if (res) {
            return Response.status(201).entity("Contact message added successfully").build();
        } else {
            return Response.status(500).entity("Error adding contact message").build();
        }
    }

    // Delete a contact message by ID
    @DELETE
    @Path("{id}")
    public Response deleteContact(@PathParam("id") int id) {
        boolean res = dbUtils.deleteContact(id);
        if (res) {
            return Response.status(200).entity("Contact message deleted successfully").build();
        } else {
            return Response.status(500).entity("Error deleting contact message").build();
        }
    }
}
