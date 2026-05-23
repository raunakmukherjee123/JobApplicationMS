package com.example.companyms;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    boolean updateCompany(Integer id,Company updatedCompany);

    Company create(Company company);

    boolean delete(Integer id);

    Company getById(Integer id);
}
