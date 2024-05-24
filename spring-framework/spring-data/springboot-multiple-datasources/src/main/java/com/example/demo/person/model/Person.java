package com.example.demo.person.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
}
