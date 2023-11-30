package com.prototype.qapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String displayName;
    //private int points;
    //private boolean isAnonymous;
    // Relationship Mapping
    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // One user can have many questions
}
