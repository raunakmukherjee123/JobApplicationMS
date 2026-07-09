package com.example.jobms.exceptions;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException(String message)
    {
        super(message);
    }
}
