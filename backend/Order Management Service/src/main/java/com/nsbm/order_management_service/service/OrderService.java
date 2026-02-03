package com.nsbm.order_management_service.service;

import com.nsbm.order_management_service.dto.OrderRequest;
import com.nsbm.order_management_service.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
}
