package com.example.companyms;

import com.example.companyms.projections.CompanyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.ScopedValue;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    @Query("SELECT c.name as name,c.description as description, c.averageRating as averageRating from Company c where c.id=:id")
    CompanyProjection findCompanyById(Integer id);
}
