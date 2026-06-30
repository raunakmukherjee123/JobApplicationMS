package com.example.reviewms;

import com.example.reviewms.dto.ReviewDTO;
import com.example.reviewms.messaging.RabbitMessageProducer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/all")
    public ResponseEntity<?> gerAllReviews(@RequestParam Integer companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addReview(@RequestParam Integer companyId, @RequestBody @Valid ReviewDTO reviewDTO)
    {
        return new ResponseEntity<>(reviewService.addReview(companyId,reviewDTO),HttpStatus.CREATED);
    }

    @GetMapping("/review/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable Integer companyId,@PathVariable Integer reviewId)
    {
        return new ResponseEntity<>(reviewService.getReviewBydId(reviewId), HttpStatus.OK);
    }

    @PutMapping("/review/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Integer reviewId, @RequestBody Review review)
    {
        return new ResponseEntity<>(reviewService.updateReview(reviewId,review), HttpStatus.OK);
    }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer reviewId)
    {
        return new ResponseEntity<>(reviewService.deleteReview(reviewId), HttpStatus.OK);
    }

    @GetMapping("/averageRating")
    public Double getAverageRating(@RequestParam Integer companyId)
    {
        List<Review> reviews=reviewService.getAllReviews(companyId);

        return reviews.stream().mapToDouble(review->review.getRating())
                .average()
                .orElse(0.0);
    }
}
