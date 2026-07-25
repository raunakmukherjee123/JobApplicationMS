package com.example.reviewms;

import com.example.reviewms.projection.ReviewProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

//    @Query(value = "select * from review where company_id=?:companyId",nativeQuery = true)
    List<Review> findByCompanyId(Integer companyId);

    @Query(value = """
            select r.title as title,
            r.description as description,
            r.rating as rating
            from Review r
            where r.id = :reviewId
            """)
    ReviewProjection findReviewById(Integer reviewId);
}
