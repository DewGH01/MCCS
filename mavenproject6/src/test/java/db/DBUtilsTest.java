/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package db;

import java.sql.Connection;
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
    
    public DBUtilsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class DBUtils.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        DBUtils instance = new DBUtils();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkConnection method, of class DBUtils.
     */
    @Test
    public void testCheckConnection() {
        System.out.println("checkConnection");
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.checkConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DBUtils.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DBUtils.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCar method, of class DBUtils.
     */
    @Test
    public void testAddCar() {
        System.out.println("addCar");
        Car car = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addCar(car);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCar method, of class DBUtils.
     */
    @Test
    public void testUpdateCar() {
        System.out.println("updateCar");
        Car car = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.updateCar(car);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCar method, of class DBUtils.
     */
    @Test
    public void testDeleteCar() {
        System.out.println("deleteCar");
        int carId = 0;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.deleteCar(carId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCars method, of class DBUtils.
     */
    @Test
    public void testGetCars() {
        System.out.println("getCars");
        DBUtils instance = new DBUtils();
        List<Car> expResult = null;
        List<Car> result = instance.getCars();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCar method, of class DBUtils.
     */
    @Test
    public void testGetCar() throws Exception {
        System.out.println("getCar");
        int carId = 0;
        DBUtils instance = new DBUtils();
        Car expResult = null;
        Car result = instance.getCar(carId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCarAvailability method, of class DBUtils.
     */
    @Test
    public void testSetCarAvailability() {
        System.out.println("setCarAvailability");
        int carId = 0;
        boolean isAvailable = false;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.setCarAvailability(carId, isAvailable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarsByAvailability method, of class DBUtils.
     */
    @Test
    public void testGetCarsByAvailability() {
        System.out.println("getCarsByAvailability");
        boolean isAvailable = false;
        DBUtils instance = new DBUtils();
        List<Car> expResult = null;
        List<Car> result = instance.getCarsByAvailability(isAvailable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarsByMakeAndModel method, of class DBUtils.
     */
    @Test
    public void testGetCarsByMakeAndModel() {
        System.out.println("getCarsByMakeAndModel");
        String make = "";
        String model = "";
        DBUtils instance = new DBUtils();
        List<Car> expResult = null;
        List<Car> result = instance.getCarsByMakeAndModel(make, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDriver method, of class DBUtils.
     */
    @Test
    public void testAddDriver() {
        System.out.println("addDriver");
        Driver driver = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addDriver(driver);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDriver method, of class DBUtils.
     */
    @Test
    public void testUpdateDriver() {
        System.out.println("updateDriver");
        Driver driver = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.updateDriver(driver);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDriver method, of class DBUtils.
     */
    @Test
    public void testDeleteDriver() {
        System.out.println("deleteDriver");
        int driverId = 0;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.deleteDriver(driverId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDrivers method, of class DBUtils.
     */
    @Test
    public void testGetDrivers() {
        System.out.println("getDrivers");
        DBUtils instance = new DBUtils();
        List<Driver> expResult = null;
        List<Driver> result = instance.getDrivers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDriver method, of class DBUtils.
     */
    @Test
    public void testGetDriver() throws Exception {
        System.out.println("getDriver");
        int driverId = 0;
        DBUtils instance = new DBUtils();
        Driver expResult = null;
        Driver result = instance.getDriver(driverId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDriverAvailability method, of class DBUtils.
     */
    @Test
    public void testSetDriverAvailability() {
        System.out.println("setDriverAvailability");
        int driverId = 0;
        boolean isAvailable = false;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.setDriverAvailability(driverId, isAvailable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDriverAvailability method, of class DBUtils.
     */
    @Test
    public void testGetDriverAvailability() {
        System.out.println("getDriverAvailability");
        int driverId = 0;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.getDriverAvailability(driverId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBooking method, of class DBUtils.
     */
    @Test
    public void testAddBooking() {
        System.out.println("addBooking");
        Booking booking = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addBooking(booking);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBooking method, of class DBUtils.
     */
    @Test
    public void testUpdateBooking() {
        System.out.println("updateBooking");
        Booking booking = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.updateBooking(booking);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBooking method, of class DBUtils.
     */
    @Test
    public void testDeleteBooking() {
        System.out.println("deleteBooking");
        int bookingId = 0;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.deleteBooking(bookingId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBookings method, of class DBUtils.
     */
    @Test
    public void testGetAllBookings() {
        System.out.println("getAllBookings");
        DBUtils instance = new DBUtils();
        List<Booking> expResult = null;
        List<Booking> result = instance.getAllBookings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingById method, of class DBUtils.
     */
    @Test
    public void testGetBookingById() {
        System.out.println("getBookingById");
        int bookingId = 0;
        DBUtils instance = new DBUtils();
        Booking expResult = null;
        Booking result = instance.getBookingById(bookingId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDistance method, of class DBUtils.
     */
    @Test
    public void testAddDistance() {
        System.out.println("addDistance");
        Distance distance = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addDistance(distance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDistance method, of class DBUtils.
     */
    @Test
    public void testUpdateDistance() {
        System.out.println("updateDistance");
        Distance distance = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.updateDistance(distance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDistance method, of class DBUtils.
     */
    @Test
    public void testDeleteDistance() {
        System.out.println("deleteDistance");
        int distanceId = 0;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.deleteDistance(distanceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDistances method, of class DBUtils.
     */
    @Test
    public void testGetAllDistances() {
        System.out.println("getAllDistances");
        DBUtils instance = new DBUtils();
        List<Distance> expResult = null;
        List<Distance> result = instance.getAllDistances();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDistanceById method, of class DBUtils.
     */
    @Test
    public void testGetDistanceById() {
        System.out.println("getDistanceById");
        int distanceId = 0;
        DBUtils instance = new DBUtils();
        Distance expResult = null;
        Distance result = instance.getDistanceById(distanceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDistanceByLocations method, of class DBUtils.
     */
    @Test
    public void testGetDistanceByLocations() {
        System.out.println("getDistanceByLocations");
        String pickupLocation = "";
        String dropLocation = "";
        DBUtils instance = new DBUtils();
        Distance expResult = null;
        Distance result = instance.getDistanceByLocations(pickupLocation, dropLocation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class DBUtils.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class DBUtils.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User user = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.updateUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class DBUtils.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        int userId = 0;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.deleteUser(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class DBUtils.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        DBUtils instance = new DBUtils();
        List<User> expResult = null;
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class DBUtils.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int userId = 0;
        DBUtils instance = new DBUtils();
        User expResult = null;
        User result = instance.getUser(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class DBUtils.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String email = "";
        String password = "";
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.loginUser(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addContactMessage method, of class DBUtils.
     */
    @Test
    public void testAddContactMessage() {
        System.out.println("addContactMessage");
        Contact contact = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addContactMessage(contact);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactMessages method, of class DBUtils.
     */
    @Test
    public void testGetContactMessages() {
        System.out.println("getContactMessages");
        DBUtils instance = new DBUtils();
        List<Contact> expResult = null;
        List<Contact> result = instance.getContactMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactById method, of class DBUtils.
     */
    @Test
    public void testGetContactById() {
        System.out.println("getContactById");
        int contactId = 0;
        DBUtils instance = new DBUtils();
        Contact expResult = null;
        Contact result = instance.getContactById(contactId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteContact method, of class DBUtils.
     */
    @Test
    public void testDeleteContact() {
        System.out.println("deleteContact");
        int contactId = 0;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.deleteContact(contactId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
