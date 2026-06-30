package com.example.reviewms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewDTO {
    @NotBlank(message = "Title should not be blank")
    private String title;

    @NotBlank(message = "Description should not be blank")
    private String description;

    @Min(0)
    private double rating;

    private Integer companyId;
}
