package com.example.onetoonebidirectional;

import com.example.onetoonebidirectional.model.Car;
import com.example.onetoonebidirectional.model.Owner;
import com.example.onetoonebidirectional.repository.CarRepository;
import com.example.onetoonebidirectional.repository.OwnerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OneToOneBidirectionalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OneToOneBidirectionalApplication.class, args);
        CarRepository carRepo = context.getBean(CarRepository.class);
        OwnerRepository ownerRepository = context.getBean(OwnerRepository.class);

        Car car = new Car(1L, "Hu");
        carRepo.save(car);
        Owner owner = new Owner(1L, "mehdi");
        owner.setCar(car);
        ownerRepository.save(owner);


    }

}
