package com.Agricode.AgricodeApp.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stock;
    private String unit;
    private String location;
    private boolean isOrganic;
    private boolean featured;
    private String harvestDate;
    private String expiryDate;
    private double rating;
    private String images;
    private Long farmerId;
    private String farmerName;
} 