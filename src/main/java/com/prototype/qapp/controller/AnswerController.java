package com.prototype.qapp.controller;

import com.prototype.qapp.entity.Answer;
import com.prototype.qapp.entity.User;
import com.prototype.qapp.service.AnswerService;
import com.prototype.qapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/submitAnswer")
    public Answer submitAnswer(@RequestBody Answer answer, Principal principal) {
        String currentUserSID = principal.getName(); // Assuming the SID is the username

        // Retrieve the user by SID from the database
        UserService userService = new UserService();
        User currentUser = userService.getUserBySID(currentUserSID);

        if (currentUser != null) {
            answer.setCreatedAt(new Date());
            answer.setUser(currentUser); // Associate the answer with the user
            return answerService.submitAnswer(answer);
        } else {
            // Handle the case where the user is not found
            // You can return an error response or throw an exception
            return null; // Replace with appropriate error handling
        }
    }

    @GetMapping ("/getAnswers")
    public Iterable<Answer> getAnswers() {
        return answerService.getAnswers();
    }
}
