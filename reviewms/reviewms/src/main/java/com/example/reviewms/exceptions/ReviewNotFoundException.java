package com.example.reviewms.exceptions;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String message)
    {
        super(message);
    }
}
