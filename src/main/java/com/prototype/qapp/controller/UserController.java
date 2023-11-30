package com.prototype.qapp.controller;

import com.prototype.qapp.entity.User;
import com.prototype.qapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
