package com.github.mehdishahdoost.transactionmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "paymentinfo_id", referencedColumnName = "id")
    private PaymentInfo paymentInfo;
}
