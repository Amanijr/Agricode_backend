package com.Agricode.AgricodeApp.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Long userId;
    private List<OrderItemDTO> items;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String paymentMethod;
    private boolean isPaid;
    private String paidAt;
    private boolean isDelivered;
    private String deliveredAt;
    private String status;
    private double totalPrice;
    private double shippingPrice;
    private double taxPrice;
    private String trackingNumber;
    private String estimatedDelivery;
} 