package com.example.jobms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDto {
    private String title;
    private String description;
    private Long minSalary;
    private Long maxSalary;
    private String location;
    private Integer companyId;
}
