package com.example.jobms;

import org.springframework.stereotype.Component;

@Component
public class JobMapper {
    public JobDto JobToJobDto(Job job,Company company)
    {
        return JobDto.builder()
                .title(job.getTitle())
                .description(job.getDescription())
                .maxSalary(job.getMaxSalary())
                .minSalary(job.getMinSalary())
                .location(job.getLocation())
                .company(company)
                .build();
    }
}
