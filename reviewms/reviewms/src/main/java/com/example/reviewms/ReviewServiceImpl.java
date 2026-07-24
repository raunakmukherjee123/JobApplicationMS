package com.example.reviewms;


import com.example.reviewms.dto.ReviewDTO;
import com.example.reviewms.exceptions.ReviewNotFoundException;
import com.example.reviewms.messaging.RabbitMessageProducer;
import com.example.reviewms.projection.ReviewProjection;
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

        if(reviewList.isEmpty())
        {
            throw new ReviewNotFoundException("No review found in database");
        }

        return reviewList;
    }

    @Override
    public String addReview(Integer companyId, ReviewDTO reviewDTO) {

        if(companyId!=null && reviewDTO!=null)
        {
            Review review=new Review();

            review.setCompanyId(companyId);
            review.setRating(reviewDTO.getRating());
            review.setTitle(reviewDTO.getTitle());
            review.setDescription(reviewDTO.getDescription());

            reviewRepository.save(review);
            rabbitMessageProducer.sendMessage(review);
            return "Review added";
        }
        return "No company found";
    }

    @Override
    public Review getReviewBydId(Integer reviewId) {
      return reviewRepository.findById(reviewId)
              .orElseThrow(()->new ReviewNotFoundException("No review found of this id"));
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

    @Override
    public ReviewProjection getReviewByProjection(Integer reviewId) {
        return null;
    }
}
