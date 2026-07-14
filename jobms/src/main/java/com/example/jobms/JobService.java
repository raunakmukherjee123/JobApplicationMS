package com.example.jobms;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void create(Job job);

    JobDto findJobById(Integer id);

    boolean deteteJobById(Integer id);

    boolean updateJob(Integer id, Job updatedjob);

    JobDTO1 findJoProjection(Integer id);
}
