package com.dailycodebuffer.Payment.service;

import com.dailycodebuffer.Payment.entity.TransactionDetails;
import com.dailycodebuffer.Payment.model.PaymentRequest;
import com.dailycodebuffer.Payment.repository.TransactionDetailRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{
    @Autowired
private TransactionDetailRepository transactionDetailRepository;
    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}",paymentRequest);
        TransactionDetails transactionDetails
                =TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        transactionDetailRepository.save(transactionDetails);
        log.info("Transcation Completed with id:{}",transactionDetails.getId());
        return transactionDetails.getId();
    }
}
