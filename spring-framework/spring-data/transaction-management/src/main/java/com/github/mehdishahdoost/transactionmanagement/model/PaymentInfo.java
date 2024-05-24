package com.github.mehdishahdoost.transactionmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="paymentInfo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentInfo {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private long amount;
    @OneToOne(mappedBy = "paymentInfo")
    private Ticket ticket;

}
