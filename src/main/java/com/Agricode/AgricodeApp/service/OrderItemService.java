package com.Agricode.AgricodeApp.service;

import com.Agricode.AgricodeApp.dto.OrderItemDTO;
import java.util.List;

public interface OrderItemService {
    OrderItemDTO getOrderItemById(Long id);
    List<OrderItemDTO> getOrderItemsByOrderId(Long orderId);
    List<OrderItemDTO> getOrderItemsByProductId(Long productId);
    OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO);
    OrderItemDTO updateOrderItem(Long id, OrderItemDTO orderItemDTO);
    void deleteOrderItem(Long id);
} 