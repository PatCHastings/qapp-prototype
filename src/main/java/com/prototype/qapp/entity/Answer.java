package com.prototype.qapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
public class Answer {

    @Id
    @GeneratedValue
    private Long id;
    private String response;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public void setUser(User currentUser) {
        this.user = currentUser;
    }
}
