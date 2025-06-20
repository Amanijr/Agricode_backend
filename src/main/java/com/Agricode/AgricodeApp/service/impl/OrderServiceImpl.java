package com.Agricode.AgricodeApp.service.impl;

import com.Agricode.AgricodeApp.dto.OrderDTO;
import com.Agricode.AgricodeApp.dto.OrderItemDTO;
import com.Agricode.AgricodeApp.entity.Order;
import com.Agricode.AgricodeApp.entity.OrderItem;
import com.Agricode.AgricodeApp.repository.OrderRepository;
import com.Agricode.AgricodeApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private OrderDTO mapToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUser() != null ? order.getUser().getId() : null);
        if (order.getItems() != null) {
            dto.setItems(order.getItems().stream().map(this::mapItemToDTO).collect(Collectors.toList()));
        }
        dto.setStreet(order.getStreet());
        dto.setCity(order.getCity());
        dto.setState(order.getState());
        dto.setCountry(order.getCountry());
        dto.setZipCode(order.getZipCode());
        dto.setPaymentMethod(order.getPaymentMethod());
        dto.setPaid(order.isPaid());
        dto.setPaidAt(order.getPaidAt());
        dto.setDelivered(order.isDelivered());
        dto.setDeliveredAt(order.getDeliveredAt());
        dto.setStatus(order.getStatus());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setShippingPrice(order.getShippingPrice());
        dto.setTaxPrice(order.getTaxPrice());
        dto.setTrackingNumber(order.getTrackingNumber());
        dto.setEstimatedDelivery(order.getEstimatedDelivery());
        return dto;
    }

    private OrderItemDTO mapItemToDTO(OrderItem item) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setId(item.getId());
        dto.setProductId(item.getProduct() != null ? item.getProduct().getId() : null);
        dto.setProductName(item.getProduct() != null ? item.getProduct().getName() : null);
        dto.setPrice(item.getPrice());
        dto.setQuantity(item.getQuantity());
        dto.setName(item.getName());
        dto.setImage(item.getImage());
        return dto;
    }

    private Order mapToEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setStreet(dto.getStreet());
        order.setCity(dto.getCity());
        order.setState(dto.getState());
        order.setCountry(dto.getCountry());
        order.setZipCode(dto.getZipCode());
        order.setPaymentMethod(dto.getPaymentMethod());
        order.setPaid(dto.isPaid());
        order.setPaidAt(dto.getPaidAt());
        order.setDelivered(dto.isDelivered());
        order.setDeliveredAt(dto.getDeliveredAt());
        order.setStatus(dto.getStatus());
        order.setTotalPrice(dto.getTotalPrice());
        order.setShippingPrice(dto.getShippingPrice());
        order.setTaxPrice(dto.getTaxPrice());
        order.setTrackingNumber(dto.getTrackingNumber());
        order.setEstimatedDelivery(dto.getEstimatedDelivery());
        // User and items mapping should be handled in service if needed
        return order;
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        return orderRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = mapToEntity(orderDTO);
        return mapToDTO(orderRepository.save(order));
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStreet(orderDTO.getStreet());
        order.setCity(orderDTO.getCity());
        order.setState(orderDTO.getState());
        order.setCountry(orderDTO.getCountry());
        order.setZipCode(orderDTO.getZipCode());
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        order.setPaid(orderDTO.isPaid());
        order.setPaidAt(orderDTO.getPaidAt());
        order.setDelivered(orderDTO.isDelivered());
        order.setDeliveredAt(orderDTO.getDeliveredAt());
        order.setStatus(orderDTO.getStatus());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setShippingPrice(orderDTO.getShippingPrice());
        order.setTaxPrice(orderDTO.getTaxPrice());
        order.setTrackingNumber(orderDTO.getTrackingNumber());
        order.setEstimatedDelivery(orderDTO.getEstimatedDelivery());
        return mapToDTO(orderRepository.save(order));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
} 