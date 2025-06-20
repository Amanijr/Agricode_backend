package com.Agricode.AgricodeApp.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private Long id;
    private Long productId;
    private String productName;
    private double price;
    private int quantity;
    private String productImage;
} 