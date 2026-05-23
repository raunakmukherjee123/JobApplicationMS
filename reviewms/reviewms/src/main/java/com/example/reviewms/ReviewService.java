package com.example.reviewms;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Integer companyId);

    String addReview(Integer companyId, Review review);

    Review getReviewBydId(Integer reviewId);

    String updateReview(Integer reviewId, Review review);

    String deleteReview(Integer reviewId);
}
