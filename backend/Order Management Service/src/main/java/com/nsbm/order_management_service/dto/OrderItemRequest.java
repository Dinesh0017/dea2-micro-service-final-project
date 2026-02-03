package com.nsbm.order_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
    private String itemCode;
    private Integer quantity;
    private BigDecimal price;
}
