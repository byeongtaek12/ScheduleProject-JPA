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
    @JoinColumn(name = "writer_id")
    private Writer writer;

    private String title;

    private String contents;

    public Schedulev2() {

    }

    public Schedulev2(Writer writer, String title, String contents) {
        this.writer=writer;
        this.title=title;
        this.contents=contents;
    }


}
