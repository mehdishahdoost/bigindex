package com.github.mehdishahdoost.springbootwebflux.dao;

import com.github.mehdishahdoost.springbootwebflux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {


    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomer() {
        return IntStream.rangeClosed(1, 50).peek(System.out::println).
                mapToObj(o -> new Customer(o, "customer" + o)).collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream() {
        return Flux.range(1, 50).
                delayElements(Duration.ofSeconds(1)).
                doOnNext(System.out::println).
                map(o -> new Customer(o, "customer" + o));
    }
}
