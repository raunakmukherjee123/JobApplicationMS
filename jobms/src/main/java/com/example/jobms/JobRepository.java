package com.example.jobms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job,Integer> {

    @Query("""
            SELECT j.title AS title,
                   j.description AS description,
                   j.minSalary AS minSalary,
                   j.maxSalary AS maxSalary,
                   j.location AS location
            FROM Job j
            WHERE j.id = :id
            """)
    JobDTO1 findJobProjectionById(Integer id);
}
