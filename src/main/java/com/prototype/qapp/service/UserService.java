package com.prototype.qapp.service;

import com.prototype.qapp.entity.User;
import com.prototype.qapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // This annotation tells Spring to treat this class as a service
public class UserService {

    @Autowired // This annotation tells Spring to inject an instance of UserRepository here
    private UserRepository repository;

    public User registerUser(User user) {
        return repository.save(user);
    }
    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }
    public List<User> getUsers() {
        return repository.findAll();
    }
    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public User getUserByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "User removed! " + id;
    }
    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setDisplayName(user.getDisplayName());
        return repository.save(existingUser);
    }

}
