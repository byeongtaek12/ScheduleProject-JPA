package com.example.schedulev2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "writer")
public class Writer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    protected Writer() {

    }

    public Writer(String writer, String email, String password) {
        this.writer = writer;
        this.email = email;
        this.password = password;
    }
}
