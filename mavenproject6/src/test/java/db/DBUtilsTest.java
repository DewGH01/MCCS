/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package db;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dewmi
 */
public class DBUtilsTest {
    
    private DBUtils instance;

    public DBUtilsTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        // Set up any resources needed for the entire test class
    }

    @AfterAll
    public static void tearDownClass() {
        // Clean up resources after the entire test class is finished
    }

    @BeforeEach
    public void setUp() {
        // Create a new instance before each test
        instance = new DBUtils();
    }

    @AfterEach
    public void tearDown() {
        // Clean up after each test if necessary
    }

    /**
     * Test of getConnection method, of class DBUtils.
     */
    @Test
    public void testGetConnection() throws Exception {
         System.out.println("getConnection");
        Connection result = instance.getConnection();
        assertNotNull(result); // Ensure the connection is not null
    }

    /**
     * Test of checkConnection method, of class DBUtils.
     */
    @Test
    public void testCheckConnection() {
        System.out.println("checkConnection");
        boolean result = instance.checkConnection();
        assertTrue(result); // Assuming the connection is valid
    }


    /**
     * Test of addCar method, of class DBUtils.
     */
    @Test
    public void testAddCar() {
        System.out.println("addCar");
        Car car = new Car();
        car.setModel("Toyota");
        car.setMake("Corolla");
        car.setPricePerKm(10.0);

        boolean result = instance.addCar(car);
        assertTrue(result); // Assuming the car was added successfully
    }

    /**
     * Test of updateCar method, of class DBUtils.
     */
    @Test
    public void testUpdateCar() {
       System.out.println("updateCar");
        Car car = new Car();
        car.setCarId(1); // Assuming this car already exists
        car.setModel("Honda");
        car.setMake("Civi");
        car.setPricePerKm(12.0);

        boolean result = instance.updateCar(car);
        assertTrue(result); // Assuming the car was updated successfully
    }

     

    /**
     * Test of getCars method, of class DBUtils.
     */
    @Test
    public void testGetCars() {
        System.out.println("getCars");
        List<Car> result = instance.getCars();
        assertNotNull(result); // Ensure the list of cars is not null
        assertTrue(result.size() > 0); // Ensure the list contains at least one car
    }

    /**
     * Test of getCar method, of class DBUtils.
     */
    @Test
    public void testGetCar() throws Exception {
        System.out.println("getCar");
        int carId = 1; // Assuming this car ID exists
        Car result = instance.getCar(carId);
        assertNotNull(result); // Ensure the car is found
        assertEquals(carId, result.getCarId()); // Ensure the car ID matches
    }

    /**
     * Test of setCarAvailability method, of class DBUtils.
     */
    @Test
    public void testSetCarAvailability() {
       System.out.println("setCarAvailability");
        int carId = 1; // Assuming car with ID 1 exists
        boolean isAvailable = false;
        boolean result = instance.setCarAvailability(carId, isAvailable);
        assertTrue(result); // Assuming the availability status was updated successfully
    }

    /**
     * Test of getCarsByAvailability method, of class DBUtils.
     */
    @Test
    public void testGetCarsByAvailability() {
         System.out.println("getCarsByAvailability");
        boolean isAvailable = false;
        List<Car> result = instance.getCarsByAvailability(isAvailable);
        assertNotNull(result); // Ensure the list is not null
        assertTrue(result.size() > 0); // Ensure at least one car is available
    }

    

    /**
     * Test of addDriver method, of class DBUtils.
     */
    @Test
    public void testAddDriver() {
          System.out.println("addDriver");

        Driver driver = new Driver(0, "John Doe", "555-1234", true, "A123456", "2025-03-10");
        boolean result = instance.addDriver(driver);

        assertTrue(result); // Ensure the driver was added successfully
    }

    /**
     * Test of updateDriver method, of class DBUtils.
     */
    @Test
    public void testUpdateDriver() {
         System.out.println("updateDriver");

        Driver driver = new Driver(1, "Prasanna Lakmal", "555-4321", true, "A123456", "2025-03-10");
        boolean result = instance.updateDriver(driver);

        assertTrue(result); // Ensure the driver was updated successfully
    }

     

    /**
     * Test of getDrivers method, of class DBUtils.
     */
    @Test
    public void testGetDrivers() {
        System.out.println("getDrivers");

        List<Driver> result = instance.getDrivers();
        assertNotNull(result); // Ensure the list is not null
        assertTrue(result.size() > 0); // Ensure at least one driver exists
    }

    /**
     * Test of getDriver method, of class DBUtils.
     */
    @Test
    public void testGetDriver() throws Exception {
      System.out.println("getDriver");

        int driverId = 1; // Assuming this driver ID exists
        Driver result = instance.getDriver(driverId);

        assertNotNull(result); // Ensure the result is not null
        assertEquals(driverId, result.getDriverId()); // Ensure the driver ID matches
    }

    /**
     * Test of setDriverAvailability method, of class DBUtils.
     */
    @Test
    public void testSetDriverAvailability() {
         System.out.println("setDriverAvailability");

        int driverId = 1; // Assuming driver with ID 1 exists
        boolean isAvailable = false;
        boolean result = instance.setDriverAvailability(driverId, isAvailable);

        assertTrue(result); // Ensure the availability was successfully set
    }

     
    /**
     * Test of addBooking method, of class DBUtils.
     */
    @Test
    public void testAddBooking() {
        System.out.println("addBooking");

        Booking booking = new Booking(0, 1, "John Doe", "john.doe@example.com", 
                                      "Pickup Location", "Drop Location", 1, 2, 10.5, 1, "2025-03-10", "2025-03-10");

        boolean result = instance.addBooking(booking);

        assertTrue(result, "Booking should be added successfully.");
    }

    /**
     * Test of updateBooking method, of class DBUtils.
     */
    @Test
    public void testUpdateBooking() {
         System.out.println("updateBooking");

        Booking booking = new Booking(16, 1, "John Doe", "john.doe@example.com", 
                                      "Pickup Location", "Drop Location", 1, 2, 10.5, 1, "2025-03-10", "2025-03-10");

        boolean result = instance.updateBooking(booking);

        assertTrue(result, "Booking should be updated successfully.");
    }

     

    /**
     * Test of getAllBookings method, of class DBUtils.
     */
    @Test
    public void testGetAllBookings() {
          System.out.println("getAllBookings");

        List<Booking> result = instance.getAllBookings();
        assertNotNull(result); // Ensure the list is not null
        assertTrue(result.size() > 0); // Ensure the list contains at least one booking
    }

    /**
     * Test of getBookingById method, of class DBUtils.
     */
    @Test
    public void testGetBookingById() {
         System.out.println("getBookingById");

        int bookingId = 13; // Assuming this booking ID exists
        Booking result = instance.getBookingById(bookingId);

        assertNotNull(result, "Booking should not be null.");
        assertEquals(bookingId, result.getBookingId(), "Booking ID should match.");
    }

    /**
     * Test of addDistance method, of class DBUtils.
     */
    @Test
    public void testAddDistance() {
        System.out.println("addDistance");

        Distance distance = new Distance(0, "Location A", "Location B", 10.5, "2025-03-10");
        boolean result = instance.addDistance(distance);

        assertTrue(result, "Distance should be added successfully.");
    }

    /**
     * Test of updateDistance method, of class DBUtils.
     */
    @Test
    public void testUpdateDistance() {
         System.out.println("updateDistance");

        Distance distance = new Distance(1, "Colombo Fort", "Colombo 07", 15.0, "2025-03-10");
        boolean result = instance.updateDistance(distance);

        assertTrue(result, "Distance should be updated successfully.");
    }

     

    /**
     * Test of getAllDistances method, of class DBUtils.
     */
    @Test
    public void testGetAllDistances() {
        System.out.println("getAllDistances");

        List<Distance> result = instance.getAllDistances();
        assertNotNull(result); // Ensure the list is not null
        assertTrue(result.size() > 0); // Ensure the list contains at least one distance
    }

    /**
     * Test of getDistanceById method, of class DBUtils.
     */
    @Test
    public void testGetDistanceById() {
         System.out.println("getDistanceById");

        int distanceId = 1; // Assumed that a distance with this ID exists
        Distance result = instance.getDistanceById(distanceId);

        assertNotNull(result); // Ensure a non-null result is returned
        assertEquals(distanceId, result.getDistanceId()); // Ensure the correct distanceId is returned
    }

    /**
     * Test of getDistanceByLocations method, of class DBUtils.
     */
    @Test
    public void testGetDistanceByLocations() {
        System.out.println("getDistanceByLocations");

        String pickupLocation = "Location A";
        String dropLocation = "Location B";
        Distance result = instance.getDistanceByLocations(pickupLocation, dropLocation);

        assertNotNull(result); // Ensure a non-null result is returned
        assertEquals(pickupLocation, result.getPickupLocation()); // Ensure the pickupLocation matches
        assertEquals(dropLocation, result.getDropLocation()); // Ensure the dropLocation matches
    }

    

    /**
     * Test of getUsers method, of class DBUtils.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");

        List<User> result = instance.getUsers();
        assertNotNull(result); // Ensure the list is not null
        assertTrue(result.size() > 0); // Ensure the list contains at least one user
    }

    /**
     * Test of getUser method, of class DBUtils.
     */
    @Test
    public void testGetUser() {
         System.out.println("getUser");

        int userId = 1; // Assumed that a user with this ID exists
        User result = instance.getUser(userId);

        assertNotNull(result); // Ensure the result is not null
        assertEquals(userId, result.getUserId()); // Ensure the correct userId is returned
    }

    /**
     * Test of loginUser method, of class DBUtils.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");

        String email = "john.doe@example.com";
        String password = "password123";

        boolean result = instance.loginUser(email, password);

        assertTrue(result, "Login should be successful.");
    }

    /**
     * Test of addContactMessage method, of class DBUtils.
     */
    @Test
    public void testAddContactMessage() {
          System.out.println("addContactMessage");

        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Contact contact = new Contact(0, "John Doe", "john.doe@example.com", "Test message.", currentTime);
        boolean result = instance.addContactMessage(contact);

        assertTrue(result, "Contact message should be added successfully.");
    }

    /**
     * Test of getContactMessages method, of class DBUtils.
     */
    @Test
    public void testGetContactMessages() {
       System.out.println("getContactMessages");

        List<Contact> result = instance.getContactMessages();
        assertNotNull(result); // Ensure the list is not null
        assertTrue(result.size() > 0); // Ensure the list contains at least one message
    }

    /**
     * Test of getContactById method, of class DBUtils.
     */
    @Test
    public void testGetContactById() {
       System.out.println("getContactById");

        int contactId = 2; // Assuming contact with ID 1 exists
        Contact result = instance.getContactById(contactId);

        assertNotNull(result); // Ensure a non-null result is returned
        assertEquals(contactId, result.getId()); // Ensure the correct contact ID is returned
    }

    
    
}
