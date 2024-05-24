package com.github.mehdishahdoost.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comment")
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    private long articleId;

}
