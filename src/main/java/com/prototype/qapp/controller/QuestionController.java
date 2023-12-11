package com.prototype.qapp.controller;

import com.prototype.qapp.entity.Question;
import com.prototype.qapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/createQuestion")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question createdQuestion = questionService.createQuestion(question);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }

    @PostMapping("/submitQuestion")
    public Question submitQuestion(@RequestBody  Question question) {
        return questionService.submitQuestion(question);
    }

    @PostMapping("/addAnswerToQuestion/{questionId}/{answerId}")
    public Question addAnswerToQuestion(@PathVariable Long questionId, @PathVariable Long answerId) {
        return questionService.addAnswerToQuestion(questionId, answerId);
    }

//    @GetMapping("/getsQuestions")
//    public ResponseEntity<List<Question>> GetsQuestions() {
//        List<Question> questions = questionService.GetQuestions();
//        return new ResponseEntity<>(questions, HttpStatus.OK);
//    }
    @GetMapping("/getQuestions")
    public List<Question> GetQuestions() {
        return questionService.GetQuestions();
    }
    @GetMapping("/getQuestionById/{id}")
    public Question GetQuestionById(Long id) {
        return questionService.GetQuestionById(id);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable  Long id) {
        return questionService.deleteQuestion(id);
    }

}


