package com.example.companyms;

import com.example.companyms.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    boolean updateCompany(Integer id,Company updatedCompany);

    Company create(Company company);

    boolean delete(Integer id);

    Company getById(Integer id);

    public void updateCompanyRating(ReviewMessage reviewMessage);
}
