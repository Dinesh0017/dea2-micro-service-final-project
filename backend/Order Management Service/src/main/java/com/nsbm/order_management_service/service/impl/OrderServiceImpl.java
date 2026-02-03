package com.nsbm.order_management_service.service.impl;

import com.nsbm.order_management_service.dto.OrderItemRequest;
import com.nsbm.order_management_service.dto.OrderRequest;
import com.nsbm.order_management_service.entity.Order;
import com.nsbm.order_management_service.entity.OrderItem;
import com.nsbm.order_management_service.repository.OrderRepository;
import com.nsbm.order_management_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setCustomerId(orderRequest.getCustomerId());
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> orderItems = orderRequest.getOrderItems()
                .stream()
                .map(this::mapToOrderItem)
                .toList();

        order.setOrderItems(orderItems);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    private OrderItem mapToOrderItem(OrderItemRequest orderItemRequest) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItemCode(orderItemRequest.getItemCode());
        orderItem.setQuantity(orderItemRequest.getQuantity());
        orderItem.setPrice(orderItemRequest.getPrice());
        return orderItem;
    }
}
