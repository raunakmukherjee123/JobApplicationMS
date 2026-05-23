package com.example.reviewms;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

//    @Query(value = "select * from review where company_id=?:companyId",nativeQuery = true)
    List<Review> findByCompanyId(Integer companyId);
}
