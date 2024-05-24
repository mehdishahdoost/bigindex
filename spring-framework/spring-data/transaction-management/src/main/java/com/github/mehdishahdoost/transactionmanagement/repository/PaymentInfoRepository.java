package com.github.mehdishahdoost.transactionmanagement.repository;

import com.github.mehdishahdoost.transactionmanagement.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
}
