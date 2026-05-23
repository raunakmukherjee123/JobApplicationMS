package com.example.jobms;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll()
    {
     return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createJob(@RequestBody Job job)
    {
      jobService.create(job);

       return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findJob(@PathVariable("id") Integer id)
    {
        Job job= jobService.findJobById(id);
        if(job!=null)
        {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Integer id)
    {
        boolean isDeleted=jobService.deteteJobById(id);

        if(isDeleted)
        {
            return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("No job with id= "+id+" is found",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Integer id,@RequestBody Job updatedjob)
    {
        boolean isUpdated=jobService.updateJob(id,updatedjob);

        if(isUpdated)
        {
            return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("No job with id= "+id+" is found",HttpStatus.NOT_FOUND);
        }
    }
}
