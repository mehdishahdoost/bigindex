package com.github.mehdishahdoost.transactionmanagement.service;

import com.github.mehdishahdoost.transactionmanagement.model.PaymentInfo;
import com.github.mehdishahdoost.transactionmanagement.repository.PaymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    int fakeAmount = 1000;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void payment() {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setAmount(1000);
        paymentInfoRepository.save(paymentInfo);
        if (fakeAmount < 2000)
            throw new RuntimeException("Manual exception");
    }
}
