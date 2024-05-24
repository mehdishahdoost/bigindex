package com.github.mehdishahdoost.transactionmanagement;

import com.github.mehdishahdoost.transactionmanagement.service.BookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TransactionManagementApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TransactionManagementApplication.class, args);
        BookingService bookingService = context.getBean(BookingService.class);
        bookingService.book();
    }

}
