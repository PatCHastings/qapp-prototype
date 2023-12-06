package com.prototype.qapp.controller;

import com.prototype.qapp.entity.Answer;
import com.prototype.qapp.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/submitAnswer")
    public Answer submitAnswer(@RequestBody  Answer answer) {
        return answerService.submitAnswer(answer);
    }
}
