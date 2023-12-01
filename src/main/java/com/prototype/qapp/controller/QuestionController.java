package com.prototype.qapp.controller;

import com.prototype.qapp.entity.Question;
import com.prototype.qapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService service;

    @PostMapping("/submitQuestion")
    public Question submitQuestion(@RequestBody  Question question) {
        return service.submitQuestion(question);
    }
}
