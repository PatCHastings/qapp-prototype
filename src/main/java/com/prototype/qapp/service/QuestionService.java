package com.prototype.qapp.service;

import com.prototype.qapp.entity.Question;
import com.prototype.qapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    public Question submitQuestion(Question question) {
        return repository.save(question);
    }
    public List<Question> GetQuestions() {
        return repository.findAll();
    }
    public Question GetQuestionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteQuestion(Long id) {
        repository.deleteById(id);
        return "Question removed! " + id;
    }
}
