package com.example.reviewms.mapper;

import com.example.reviewms.Review;
import com.example.reviewms.dto.ReviewResponse;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewResponse ReviewToReviewResponse(Review review)
    {
        return ReviewResponse.builder()
                .title(review.getTitle())
                .description(review.getDescription())
                .rating(review.getRating())
                .build();
    }
}
