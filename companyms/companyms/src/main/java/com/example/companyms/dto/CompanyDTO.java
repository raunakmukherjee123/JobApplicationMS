package com.example.companyms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyDTO {
    @NotNull(message = "Company name shouldn't be null")
    private String name;

    @NotBlank(message = "Description shouldn't be blank")
    private String description;

}
