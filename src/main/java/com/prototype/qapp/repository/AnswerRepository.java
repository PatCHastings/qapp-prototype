package com.prototype.qapp.repository;

import com.prototype.qapp.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findAnswerById(Long answerId);

    Answer findBySID(String SID);
}
