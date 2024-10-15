package com.dailycodebuffer.Payment.service;

import com.dailycodebuffer.Payment.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
