package com.project.questappbackend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name ="users")
@Data
public class User {

    @Id
    private Long id;

    private String userName;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
