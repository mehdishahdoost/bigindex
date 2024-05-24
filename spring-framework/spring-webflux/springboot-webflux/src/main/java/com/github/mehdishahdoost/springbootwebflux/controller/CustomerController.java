package com.github.mehdishahdoost.springbootwebflux.controller;

import com.github.mehdishahdoost.springbootwebflux.dto.Customer;
import com.github.mehdishahdoost.springbootwebflux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomer() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomerStream() {
        return customerService.getCustomersStream();
    }
}
