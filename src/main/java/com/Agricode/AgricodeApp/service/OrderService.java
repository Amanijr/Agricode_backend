package com.Agricode.AgricodeApp.service;

import com.Agricode.AgricodeApp.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getOrdersByUserId(Long userId);
    List<OrderDTO> getOrdersByStatus(String status);
    List<OrderDTO> getAllOrders();
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(Long id, OrderDTO orderDTO);
    void deleteOrder(Long id);
} 