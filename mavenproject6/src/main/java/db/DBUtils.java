/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.sql.Types;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


/**
 *
 * @author Dewmi
 */
public class DBUtils {

    static final String DB_URL = "jdbc:mysql://localhost:3306/megacitycab";
    static final String USER = "root";
    static final String PASS = "";

    public DBUtils() {
        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get a database connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Method to check if the database connection is successful
    public boolean checkConnection() {
        try (Connection connection = getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection to the database is successful.");
                return true; // Connection is successful
            }
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database.");
            e.printStackTrace();
        }
        return false; // Connection failed
    }

    public static void main(String[] args) {
        DBUtils dbUtils = new DBUtils();
        boolean isConnected = dbUtils.checkConnection();
        if (isConnected) {
            System.out.println("Database is connected successfully.");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }

    
// Retrieve all users
    

    // Sign up new user (Add new user with hashed password)
   
    //Car Opeartions CRUD + Necessary----------------------------------------------------------------------------
    // Add a new car
    public boolean addCar(Car car) {
        String query = "INSERT INTO car (model, make, year, price_per_km, is_available) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, car.getModel());
            pstmt.setString(2, car.getMake());
            pstmt.setInt(3, car.getYear());
            pstmt.setDouble(4, car.getPricePerKm());
            pstmt.setBoolean(5, car.isAvailable());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update an existing car
    public boolean updateCar(Car car) {
        String query = "UPDATE car SET model = ?, make = ?, year = ?, price_per_km = ?, is_available = ? WHERE car_id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, car.getModel());
            pstmt.setString(2, car.getMake());
            pstmt.setInt(3, car.getYear());
            pstmt.setDouble(4, car.getPricePerKm());
            pstmt.setBoolean(5, car.isAvailable());
            pstmt.setInt(6, car.getCarId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete a car by ID
    public boolean deleteCar(int carId) {
        String query = "DELETE FROM car WHERE car_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, carId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve all cars
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM car";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                cars.add(new Car(
                        rs.getInt("car_id"),
                        rs.getString("model"),
                        rs.getString("make"),
                        rs.getInt("year"),
                        rs.getDouble("price_per_km"),
                        rs.getBoolean("is_available"),
                        rs.getString("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }

    // Retrieve a car by ID
    public Car getCar(int carId) throws SQLException {
        String query = "SELECT * FROM car WHERE car_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, carId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Car(
                        rs.getInt("car_id"),
                        rs.getString("model"),
                        rs.getString("make"),
                        rs.getInt("year"),
                        rs.getDouble("price_per_km"),
                        rs.getBoolean("is_available"),
                        rs.getString("created_at")
                );
            }
        }
        return null;
    }

    // Set car availability (Available/Unavailable)
    public boolean setCarAvailability(int carId, boolean isAvailable) {
        String query = "UPDATE car SET is_available = ? WHERE car_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, isAvailable);
            pstmt.setInt(2, carId);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve cars by availability
    public List<Car> getCarsByAvailability(boolean isAvailable) {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM car WHERE is_available = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, isAvailable);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cars.add(new Car(
                        rs.getInt("car_id"),
                        rs.getString("model"),
                        rs.getString("make"),
                        rs.getInt("year"),
                        rs.getDouble("price_per_km"),
                        rs.getBoolean("is_available"),
                        rs.getString("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }

    // Get cars by make and model
    public List<Car> getCarsByMakeAndModel(String make, String model) {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM car WHERE make = ? AND model = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, make);
            pstmt.setString(2, model);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cars.add(new Car(
                        rs.getInt("car_id"),
                        rs.getString("model"),
                        rs.getString("make"),
                        rs.getInt("year"),
                        rs.getDouble("price_per_km"),
                        rs.getBoolean("is_available"),
                        rs.getString("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }
    
    //Driver CRUD + Other Necessary Operations------------------------------------------------------------------------------------------
    
    // Add a new driver
    public boolean addDriver(Driver driver) {
        String query = "INSERT INTO driver (driver_name, driver_phone, availability, driver_license) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, driver.getDriverName());
            pstmt.setString(2, driver.getDriverPhone());
            pstmt.setBoolean(3, driver.isAvailability());
            pstmt.setString(4, driver.getDriverLicense());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update an existing driver
    public boolean updateDriver(Driver driver) {
        String query = "UPDATE driver SET driver_name = ?, driver_phone = ?, availability = ?, driver_license = ? WHERE driver_id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, driver.getDriverName());
            pstmt.setString(2, driver.getDriverPhone());
            pstmt.setBoolean(3, driver.isAvailability());
            pstmt.setString(4, driver.getDriverLicense());
            pstmt.setInt(5, driver.getDriverId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a driver by ID
    public boolean deleteDriver(int driverId) {
        String query = "DELETE FROM driver WHERE driver_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, driverId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve all drivers
    public List<Driver> getDrivers() {
        List<Driver> drivers = new ArrayList<>();
        String query = "SELECT * FROM driver";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                drivers.add(new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("driver_name"),
                        rs.getString("driver_phone"),
                        rs.getBoolean("availability"),
                        rs.getString("driver_license"),
                        rs.getString("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    // Retrieve a driver by ID
    public Driver getDriver(int driverId) throws SQLException {
        String query = "SELECT * FROM driver WHERE driver_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, driverId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("driver_name"),
                        rs.getString("driver_phone"),
                        rs.getBoolean("availability"),
                        rs.getString("driver_license"),
                        rs.getString("created_at")
                );
            }
        }
        return null;
    }

    // Set driver availability (Available/Unavailable)
    public boolean setDriverAvailability(int driverId, boolean isAvailable) {
        String query = "UPDATE driver SET availability = ? WHERE driver_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, isAvailable);
            pstmt.setInt(2, driverId);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get driver availability by driver ID
    public boolean getDriverAvailability(int driverId) {
        String query = "SELECT availability FROM driver WHERE driver_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, driverId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getBoolean("availability");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //Booking Table-----------------------------------------------------------
    public boolean addBooking(Booking booking) {
    String query = "INSERT INTO booking (user_id, customer_name, email, pickup_location, drop_location, driver_id, car_id, price_per_km, distance_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, booking.getUserId());
        pstmt.setString(2, booking.getCustomerName());
        pstmt.setString(3, booking.getEmail());
        pstmt.setString(4, booking.getPickupLocation());
        pstmt.setString(5, booking.getDropLocation());
        pstmt.setInt(6, booking.getDriverId());
        pstmt.setInt(7, booking.getCarId());
        pstmt.setDouble(8, booking.getPricePerKm());
        pstmt.setInt(9, booking.getDistanceId());

        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace(); // Log error details
        return false;
    }
}



    // Update an existing booking
    public boolean updateBooking(Booking booking) {
    String query = "UPDATE booking SET user_id = ?, customer_name = ?, email = ?, pickup_location = ?, drop_location = ?, driver_id = ?, car_id = ?, price_per_km = ?, distance_id = ? WHERE booking_id = ?";

    try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, booking.getUserId());
        pstmt.setString(2, booking.getCustomerName());
        pstmt.setString(3, booking.getEmail());
        pstmt.setString(4, booking.getPickupLocation());
        pstmt.setString(5, booking.getDropLocation());
        pstmt.setInt(6, booking.getDriverId());
        pstmt.setInt(7, booking.getCarId());
        pstmt.setDouble(8, booking.getPricePerKm());
        pstmt.setInt(9, booking.getDistanceId());
        pstmt.setInt(10, booking.getBookingId());

        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace(); // Log error details
        return false;
    }
}

    public boolean deleteBooking(int bookingId) {
    String query = "DELETE FROM booking WHERE booking_id = ?";

    try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, bookingId);
        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace(); // Log error details
        return false;
    }
}

    // Retrieve all bookings
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                bookings.add(new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("user_id"),
                        rs.getString("customer_name"),  // Email retrieved here
                        rs.getString("email"),  // Email retrieved here
                        rs.getString("pickup_location"),
                        rs.getString("drop_location"),
                        rs.getInt("driver_id"),
                        rs.getInt("car_id"),
                        rs.getDouble("price_per_km"),
                        rs.getInt("distance_id"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    // Retrieve a booking by ID
    public Booking getBookingById(int bookingId) {
        String query = "SELECT * FROM booking WHERE booking_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookingId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("user_id"),
                        rs.getString("customer_name"),  // Email retrieved here
                        rs.getString("email"),  // Email retrieved here
                        rs.getString("pickup_location"),
                        rs.getString("drop_location"),
                        rs.getInt("driver_id"),
                        rs.getInt("car_id"),
                        rs.getDouble("price_per_km"),
                        rs.getInt("distance_id"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    static class CarService_JerseyClient {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://localhost:8080/mavenproject6/resources";

        public CarService_JerseyClient() {
            client = javax.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI).path("cars");
        }

        public <T> T getCarsByMakeAndModel(Class<T> responseType, String model, String make) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (model != null) {
                resource = resource.queryParam("model", model);
            }
            if (make != null) {
                resource = resource.queryParam("make", make);
            }
            resource = resource.path("search");
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getCar(Class<T> responseType, String id) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public Response addCar(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public Response deleteCar(String id) throws ClientErrorException {
            return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete(Response.class);
        }

        public <T> T getCarsByAvailability(Class<T> responseType, String status) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("availability/{0}", new Object[]{status}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public <T> T getCars(Class<T> responseType) throws ClientErrorException {
            WebTarget resource = webTarget;
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public Response updateCar(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public Response setCarAvailability(Object requestEntity, String id) throws ClientErrorException {
            return webTarget.path(java.text.MessageFormat.format("{0}/availability", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public void close() {
            client.close();
        }
    }
    
    
    /////////////////////////////////////////////////////
    
    //////////////////////////////////////////////////////
    
       // Add a new distance
    public boolean addDistance(Distance distance) {
        String query = "INSERT INTO distance (pickup_location, drop_location, distance_km) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, distance.getPickupLocation());
            pstmt.setString(2, distance.getDropLocation());
            pstmt.setDouble(3, distance.getDistanceKm());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update an existing distance
    public boolean updateDistance(Distance distance) {
        String query = "UPDATE distance SET pickup_location = ?, drop_location = ?, distance_km = ? WHERE distance_id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, distance.getPickupLocation());
            pstmt.setString(2, distance.getDropLocation());
            pstmt.setDouble(3, distance.getDistanceKm());
            pstmt.setInt(4, distance.getDistanceId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete a distance by ID
    public boolean deleteDistance(int distanceId) {
        String query = "DELETE FROM distance WHERE distance_id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, distanceId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Retrieve all distances
    public List<Distance> getAllDistances() {
        List<Distance> distances = new ArrayList<>();
        String query = "SELECT * FROM distance";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                distances.add(new Distance(
                        rs.getInt("distance_id"),
                        rs.getString("pickup_location"),
                        rs.getString("drop_location"),
                        rs.getDouble("distance_km"),
                        rs.getString("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return distances;
    }

    // Retrieve a distance by ID
    public Distance getDistanceById(int distanceId) {
        String query = "SELECT * FROM distance WHERE distance_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, distanceId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Distance(
                        rs.getInt("distance_id"),
                        rs.getString("pickup_location"),
                        rs.getString("drop_location"),
                        rs.getDouble("distance_km"),
                        rs.getString("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Optionally, you can add a method to retrieve a distance by pickup and drop location if needed
    public Distance getDistanceByLocations(String pickupLocation, String dropLocation) {
        String query = "SELECT * FROM distance WHERE pickup_location = ? AND drop_location = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, pickupLocation);
            pstmt.setString(2, dropLocation);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Distance(
                        rs.getInt("distance_id"),
                        rs.getString("pickup_location"),
                        rs.getString("drop_location"),
                        rs.getDouble("distance_km"),
                        rs.getString("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    
    //////////////////////////////////////////////////////
    
    //////////////////////////////////////////////////////
    
      public boolean addUser(User user) {
        String query = "INSERT INTO user (name, address, nic, email, password, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getAddress());
            pstmt.setString(3, user.getNic());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getRole());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update an existing user
    public boolean updateUser(User user) {
        String query = "UPDATE user SET name = ?, address = ?, nic = ?, email = ?, password = ?, role = ? WHERE user_id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getAddress());
            pstmt.setString(3, user.getNic());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getRole());
            pstmt.setInt(7, user.getUserId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete a user by ID
    public boolean deleteUser(int userId) {
        String query = "DELETE FROM user WHERE user_id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Retrieve all users
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("nic"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Retrieve a single user by ID
    public User getUser(int userId) {
        String query = "SELECT * FROM user WHERE user_id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("nic"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
        // Validate user credentials for login
        public boolean loginUser(String email, String password) {
            String query = "SELECT password FROM user WHERE email = ?";

            try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, email);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    return storedPassword.equals(password);  // Compare stored password with the input password
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;  // Return false if email doesn't exist or passwords don't match
        }

//------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------
 // Add a new contact message
    public boolean addContactMessage(Contact contact) {
        String query = "INSERT INTO contactUs (name, email, message) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3, contact.getMessage());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve all contact messages
    public List<Contact> getContactMessages() {
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM contactUs";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                contacts.add(new Contact(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("message"),
                        rs.getString("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    // Retrieve a contact message by ID
    public Contact getContactById(int contactId) {
        String query = "SELECT * FROM contactUs WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, contactId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Contact(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("message"),
                        rs.getString("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete a contact message by ID
    public boolean deleteContact(int contactId) {
        String query = "DELETE FROM contactUs WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, contactId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}


