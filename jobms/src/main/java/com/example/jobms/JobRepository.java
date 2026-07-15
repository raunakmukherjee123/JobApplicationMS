package com.example.jobms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job,Integer> {

    @Query("""
            SELECT j.title, j.description, j.minSalary, j.maxSalary, j.location
            FROM Job j
            WHERE j.id = :id
            """)
    JobDTO1 findJobProjectionById(Integer id);
}
