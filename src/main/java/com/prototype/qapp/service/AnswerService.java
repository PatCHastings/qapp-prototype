package com.prototype.qapp.service;

import com.prototype.qapp.entity.Answer;
import com.prototype.qapp.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Answer submitAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> GetAnswers() {
        return answerRepository.findAll();
    }

    public Answer GetAnswerById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }


}
