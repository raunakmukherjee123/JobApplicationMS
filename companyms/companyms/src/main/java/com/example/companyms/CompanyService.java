package com.example.companyms;

import com.example.companyms.dto.CompanyDTO;
import com.example.companyms.dto.ReviewMessage;
import com.example.companyms.projections.CompanyProjection;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    boolean updateCompany(Integer id,Company updatedCompany);

    Company create(CompanyDTO companyDTO);

    boolean delete(Integer id);

    CompanyProjection getById(Integer id);

    public void updateCompanyRating(ReviewMessage reviewMessage);
}
