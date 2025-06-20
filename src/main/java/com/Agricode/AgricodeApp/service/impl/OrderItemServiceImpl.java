package com.Agricode.AgricodeApp.service.impl;

import com.Agricode.AgricodeApp.dto.OrderItemDTO;
import com.Agricode.AgricodeApp.entity.OrderItem;
import com.Agricode.AgricodeApp.repository.OrderItemRepository;
import com.Agricode.AgricodeApp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    private OrderItemDTO mapToDTO(OrderItem item) {
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

    private OrderItem mapToEntity(OrderItemDTO dto) {
        OrderItem item = new OrderItem();
        item.setId(dto.getId());
        item.setPrice(dto.getPrice());
        item.setQuantity(dto.getQuantity());
        item.setName(dto.getName());
        item.setImage(dto.getImage());
        // Product and order mapping should be handled in service if needed
        return item;
    }

    @Override
    public OrderItemDTO getOrderItemById(Long id) {
        return orderItemRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<OrderItemDTO> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderItemDTO> getOrderItemsByProductId(Long productId) {
        return orderItemRepository.findByProductId(productId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem item = mapToEntity(orderItemDTO);
        return mapToDTO(orderItemRepository.save(item));
    }

    @Override
    public OrderItemDTO updateOrderItem(Long id, OrderItemDTO orderItemDTO) {
        OrderItem item = orderItemRepository.findById(id).orElseThrow();
        item.setPrice(orderItemDTO.getPrice());
        item.setQuantity(orderItemDTO.getQuantity());
        item.setName(orderItemDTO.getName());
        item.setImage(orderItemDTO.getImage());
        return mapToDTO(orderItemRepository.save(item));
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
} 