package com.prototype.qapp.repository;

import com.prototype.qapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    // You can add custom query methods here if needed
    Question findByQuestionId(Long questionId);
}
