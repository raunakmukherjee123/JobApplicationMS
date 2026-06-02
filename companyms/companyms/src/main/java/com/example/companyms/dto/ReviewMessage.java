package com.example.companyms.dto;

import lombok.Data;

@Data
public class ReviewMessage {
    private String title;

    private String description;

    private double rating;

    private Integer companyId;
}
