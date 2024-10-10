package com.dailycodework.dreamshops.dto;

import com.dailycodework.dreamshops.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class OrderDto {

    private Long orderId;
    private LocalDate orderDate;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private List<OrderItemDto> orderItems = new ArrayList<>();

}
