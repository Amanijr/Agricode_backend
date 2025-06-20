package com.Agricode.AgricodeApp.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    private int rating;
    private String comment;
    private String date;
    private Long userId;
    private String userName;
    private Long productId;
} 