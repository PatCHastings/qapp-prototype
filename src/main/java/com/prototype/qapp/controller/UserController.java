package com.prototype.qapp.controller;

import com.prototype.qapp.entity.User;
import com.prototype.qapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            // Validate and save the user registration data
            userService.registerUser(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Handle any exceptions (e.g., duplicate SID) and return an error response
            log.error("Registration error: ", e);
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestParam String SID) {
        User user = userService.getUserBySID(SID);

        if (user != null) {
            return ResponseEntity.ok().build(); // SID is valid
        } else {
            return ResponseEntity.notFound().build(); // SID not found
        }
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody  User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody  List<User> users) {
        return userService.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.getUsers();
    }
    @GetMapping("/userById/{id}")
    public User findUserById(@PathVariable  Long id) {
         return userService.getUserById(id);
    }
    @GetMapping("/user/{name}") // This is a custom route
    public User findUserByName(@PathVariable  String name) {
        return userService.getUserByUserName(name);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody  User user) {
        return userService.registerUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable  Long id) {
        return userService.deleteUser(id);
    }
}
