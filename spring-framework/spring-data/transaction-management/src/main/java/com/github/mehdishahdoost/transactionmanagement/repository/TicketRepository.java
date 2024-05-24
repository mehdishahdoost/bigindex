package com.github.mehdishahdoost.transactionmanagement.repository;

import com.github.mehdishahdoost.transactionmanagement.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
