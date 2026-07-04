package com.example.companyms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyDTO {
    @NotBlank(message = "Company name shouldn't be blank")
    private String name;

    @NotBlank(message = "Description shouldn't be blank")
    private String description;

}
