package com.github.mehdishahdoost.transactionmanagement.service;

import com.github.mehdishahdoost.transactionmanagement.model.PaymentInfo;
import com.github.mehdishahdoost.transactionmanagement.model.Ticket;
import com.github.mehdishahdoost.transactionmanagement.repository.PaymentInfoRepository;
import com.github.mehdishahdoost.transactionmanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookingService {


    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private PaymentService paymentService;

    @Transactional
    public void book() {
        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setName("mehdi");
        ticketRepository.save(ticket);
        paymentService.payment();
    }

}
