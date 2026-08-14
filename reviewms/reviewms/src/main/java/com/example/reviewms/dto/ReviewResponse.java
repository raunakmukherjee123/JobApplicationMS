package com.example.reviewms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponse {
    private String title;

    private String description;

    private double rating;
}
