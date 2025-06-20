package com.Agricode.AgricodeApp.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    // Shipping address fields
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