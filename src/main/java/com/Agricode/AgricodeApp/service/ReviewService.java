package com.Agricode.AgricodeApp.service;

import com.Agricode.AgricodeApp.dto.ReviewDTO;
import java.util.List;

public interface ReviewService {
    ReviewDTO getReviewById(Long id);
    List<ReviewDTO> getReviewsByProduct(Long productId);
    List<ReviewDTO> getReviewsByUser(Long userId);
    ReviewDTO createReview(ReviewDTO reviewDTO);
    ReviewDTO updateReview(Long id, ReviewDTO reviewDTO);
    void deleteReview(Long id);
} 