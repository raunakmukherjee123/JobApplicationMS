package com.example.jobms.feign_client;

import com.example.jobms.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "companyms")
public interface CompanyClient {


    @GetMapping("/api/company/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable("id") Integer id);
}
