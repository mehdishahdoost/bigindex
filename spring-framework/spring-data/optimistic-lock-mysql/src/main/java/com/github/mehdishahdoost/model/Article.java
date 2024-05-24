package com.github.mehdishahdoost.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private int commentCount;

}
