package com.prototype.qapp.controller;

import com.prototype.qapp.entity.Answer;
import com.prototype.qapp.entity.User;
import com.prototype.qapp.service.AnswerService;
import com.prototype.qapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RequestMapping("api/answers")
public class AnswerController {

    private final AnswerService answerService;
    private final UserService userService;

    @Autowired
    public AnswerController(AnswerService answerService, UserService userService) {
        this.answerService = answerService;
        this.userService = userService;
    }

    @PostMapping("/submitAnswer")
    public ResponseEntity<?> submitAnswer(@RequestBody Answer answer, Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User must be authenticated.");
        }

        String currentUserSID = principal.getName(); // Assuming the SID is the username

        User currentUser = userService.getUserBySID(currentUserSID);

        if (currentUser != null) {
            answer.setCreatedAt(new Date());
            answer.setUser(currentUser); // Associate the answer with the current user
            Answer savedAnswer = answerService.submitAnswer(answer);
            return ResponseEntity.ok(savedAnswer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found in the database.");
        }
    }

    @GetMapping("/getCurrentUserSID")
    public ResponseEntity<String> getCurrentUserSID(HttpSession session) {
        String currentUserSID = (String) session.getAttribute("currentUserSID");

        if (currentUserSID != null) {
            return ResponseEntity.ok("{\"SID\": \"" + currentUserSID + "\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAnswers")
    public Iterable<Answer> getAnswers() {
        return answerService.getAnswers();
    }
}
