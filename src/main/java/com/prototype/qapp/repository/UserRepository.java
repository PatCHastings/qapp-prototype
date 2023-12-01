package com.prototype.qapp.repository;

import com.prototype.qapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Define custom queries if needed
    // Example:

    User findByUserName(String userName);



    // You can also add more specific query methods as per your application's requirements

}
