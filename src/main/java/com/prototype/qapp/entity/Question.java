package com.prototype.qapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;
    private String category;

    public Long getQuestionId() {
        return id;
    }
}
