package com.example.reviewms;


import com.example.reviewms.dto.ReviewDTO;
import com.example.reviewms.messaging.RabbitMessageProducer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final RabbitMessageProducer rabbitMessageProducer;


    @Override
    public List<Review> getAllReviews(Integer companyId) {
        List<Review> reviewList=reviewRepository.findByCompanyId(companyId);

        return reviewList;
    }

    @Override
    public String addReview(Integer companyId, ReviewDTO reviewDTO) {

        if(companyId!=null && review!=null)
        {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            rabbitMessageProducer.sendMessage(review);
            return "Review added";
        }
        return "No company found";
    }

    @Override
    public Review getReviewBydId(Integer reviewId) {
      return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public String updateReview(Integer reviewId, Review updatedReview) {
        Review review=reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setCompanyId(updatedReview.getCompanyId());
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            reviewRepository.save(review);
            return "Review updated";
        } else {
            return "Not updated";
        }
    }

    @Transactional
    @Override
    public String deleteReview( Integer reviewId) {
        Review review=reviewRepository.findById(reviewId).orElse(null);

        if (review!=null) {
            reviewRepository.deleteById(reviewId);
            return "Review has been deleted";
        }
        return "Cannot be deleted";
    }
}
