package com.Agricode.AgricodeApp.service.impl;

import com.Agricode.AgricodeApp.dto.ReviewDTO;
import com.Agricode.AgricodeApp.entity.Review;
import com.Agricode.AgricodeApp.repository.ReviewRepository;
import com.Agricode.AgricodeApp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    private ReviewDTO mapToDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setDate(review.getDate());
        if (review.getUser() != null) {
            dto.setUserId(review.getUser().getId());
            dto.setUserName(review.getUser().getName());
        }
        if (review.getProduct() != null) {
            dto.setProductId(review.getProduct().getId());
        }
        return dto;
    }

    private Review mapToEntity(ReviewDTO dto) {
        Review review = new Review();
        review.setId(dto.getId());
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        review.setDate(dto.getDate());
        // User and Product mapping should be handled in service if needed
        return review;
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        return reviewRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<ReviewDTO> getReviewsByProduct(Long productId) {
        return reviewRepository.findByProductId(productId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserId(userId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Review review = mapToEntity(reviewDTO);
        return mapToDTO(reviewRepository.save(review));
    }

    @Override
    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id).orElseThrow();
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        review.setDate(reviewDTO.getDate());
        return mapToDTO(reviewRepository.save(review));
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
} 