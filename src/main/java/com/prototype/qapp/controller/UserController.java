package com.prototype.qapp.controller;

import com.prototype.qapp.entity.User;
import com.prototype.qapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody  User user) {
        return service.registerUser(user);
    }
    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody  List<User> users) {
        return service.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }
    @GetMapping("/userById/{id}")
    public User findUserById(@PathVariable  Long id) {
        return service.getUserById(id);
    }
    @GetMapping("/user/{name}") // This is a custom route
    public User findUserByName(@PathVariable  String name) {
        return service.getUserByUserName(name);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody  User user) {
        return service.registerUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable  Long id) {
        return service.deleteUser(id);
    }
}
