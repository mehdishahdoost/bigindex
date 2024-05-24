package com.example.onetoonebidirectional.model;

import javax.persistence.*;

@Entity
@Table(name ="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    @OneToOne(mappedBy = "car")
    private Owner owner;

    public Car(Long id, String model) {
        this.id = id;
        this.model = model;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Owner getOwner() {
        return owner;
    }
}
