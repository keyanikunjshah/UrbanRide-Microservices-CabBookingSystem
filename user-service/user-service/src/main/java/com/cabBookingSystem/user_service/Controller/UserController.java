package com.cabBookingSystem.user_service.Controller;

import com.cabBookingSystem.user_service.DTO.DriverLocation;
import com.cabBookingSystem.user_service.Entity.User;
import com.cabBookingSystem.user_service.Entity.UserRole;
import com.cabBookingSystem.user_service.Service.UserService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User savedUser=userService.registerUser(user);
        return  ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestParam String email, @RequestParam String password) {
        Optional<User> user = userService.loginUser(email, password);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // Returns the User object if present
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"); // Returns an error message
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @PutMapping("/driver/{id}/update-location")
    public String updateDriverLocation(@PathVariable Long id, @RequestParam double latitude, @RequestParam double longitude) {
        Optional<User> driver = userService.getUserById(id);
        if(driver.isPresent() && driver.get().getRole() == UserRole.DRIVER) {
            driver.get().setLatitude(latitude);
            driver.get().setLongitude(longitude);
            userService.registerUser(driver.get());
            return "Driver location updated successfully";
        }
        return "Driver not found or not a driver";
    }
    @GetMapping("/driver/{id}/location")
    public DriverLocation getDriverLocation(@PathVariable Long id) {
        User driver = userService.getUserById(id).orElse(null);
        if (driver != null && driver.getRole() == UserRole.DRIVER) {
            return new DriverLocation(driver.getLatitude(), driver.getLongitude());
        }
        return null; // or return default object with null values
    }









}
