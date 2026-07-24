package com.example.reviewms;

import com.example.reviewms.dto.ReviewDTO;
import com.example.reviewms.projection.ReviewProjection;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Integer companyId);

    String addReview(Integer companyId, ReviewDTO reviewDTO);

    Review getReviewBydId(Integer reviewId);

    String updateReview(Integer reviewId, Review review);

    String deleteReview(Integer reviewId);

    ReviewProjection getReviewByProjection(Integer reviewId);
}
