package com.Agricode.AgricodeApp.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(length = 1000)
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

    // Images as comma-separated URLs (or use a separate table for images)
    private String images;

    // Farmer (owner)
    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private User farmer;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
} 