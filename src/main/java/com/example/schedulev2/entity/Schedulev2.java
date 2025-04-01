package com.example.schedulev2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedulev2")
public class Schedulev2 extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(Writer())
    private Long user_id;

    private String title;

    private String contents;



}
