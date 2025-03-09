/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mainactivity.mavenproject6.resources;

/**
 *
 * @author Dewmi
 */
import db.Booking;
import db.DBUtils;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("bookings")
public class BookingService {

    private final DBUtils dbUtils = new DBUtils();
    private final Gson gson = new Gson();

    // Get all bookings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookings() {
        List<Booking> bookings = dbUtils.getAllBookings();
        return Response.status(200).entity(gson.toJson(bookings)).build();
    }

    // Get a single booking by ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooking(@PathParam("id") int id) {
        Booking booking = dbUtils.getBookingById(id);
        if (booking == null) {
            return Response.status(404).entity("Booking not found").build();
        } else {
            return Response.status(200).entity(gson.toJson(booking)).build();
        }
    }

    // Add a new booking
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBooking(String json) {
        Booking booking = gson.fromJson(json, Booking.class);
        boolean res = dbUtils.addBooking(booking);

        if (res) {
            return Response.status(201).entity("Booking created successfully").build();
        } else {
            System.out.println("Error creating booking: " + json); // Debugging log
            return Response.status(500).entity("Error creating booking. Please check server logs for details.").build();
        }
    }



    // Update an existing booking
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBooking(@PathParam("id") int id, String json) {
        Booking booking = gson.fromJson(json, Booking.class);
        booking.setBookingId(id);  // Ensure the bookingId is set
        boolean res = dbUtils.updateBooking(booking);

        if (res) {
            return Response.status(200).entity("Booking updated successfully").build();
        } else {
            return Response.status(500).entity("Error updating booking. Please check server logs for details.").build();
        }
    }


    // Delete a booking by ID
    @DELETE
    @Path("{id}")
    public Response deleteBooking(@PathParam("id") int id) {
        boolean res = dbUtils.deleteBooking(id);
        if (res) {
            return Response.status(200).entity("Booking deleted successfully").build();
        } else {
            return Response.status(500).entity("Error deleting booking. Please check server logs for details.").build();
        }
    }

}