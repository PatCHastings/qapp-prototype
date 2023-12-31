package com.prototype.qapp.service;

import com.prototype.qapp.entity.Question;
import com.prototype.qapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    // I don't think an updateQuestion method is needed; questions should be immutable

    public String deleteQuestion(Long id) {
        repository.deleteById(id);
        return "Question removed! " + id;
    }

    public Question createQuestion(Question question) {
        return question;
    }

    public Question addAnswerToQuestion(Long questionId, Long answerId) {
        Question question = repository.findById(questionId).orElse(null);
        question.setAnswerId(answerId);
        return repository.save(question);
    }
}
