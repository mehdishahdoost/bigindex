package com.github.mehdishahdoost.springbootwebflux.service;

import com.github.mehdishahdoost.springbootwebflux.dao.CustomerDao;
import com.github.mehdishahdoost.springbootwebflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getCustomers() {
        return customerDao.getCustomer();
    }

    public Flux<Customer> getCustomersStream() {
        return customerDao.getCustomerStream();
    }
}
