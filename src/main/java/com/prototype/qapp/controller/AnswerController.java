package com.prototype.qapp.controller;

import com.prototype.qapp.entity.Answer;
import com.prototype.qapp.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/submitAnswer")
    public Answer submitAnswer(@RequestBody  Answer answer) {
        answer.setCreatedAt(new Date());
        return answerService.submitAnswer(answer);
    }
}
