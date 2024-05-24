package com.example.onetoonebidirectional.model;

import javax.persistence.*;

@Table(name="owner")
@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    public Owner(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Owner() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }
}

