package com.dailycodebuffer.OrderService.service;

import com.dailycodebuffer.OrderService.model.OrderRequest;

public interface OrderService {
    long placeOrder();

    long placeOrder(OrderRequest orderRequest);
}
