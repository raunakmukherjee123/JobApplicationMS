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
    public ResponseEntity<JobDto> findJob(@PathVariable("id") Integer id)
    {
        JobDto jobDto= jobService.findJobById(id);
        if(jobDto!=null)
        {
            return new ResponseEntity<>(jobDto, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findJobProjection(@PathVariable("id") Integer id)
    {
        return new ResponseEntity<>(jobService.findJoProjection(id),HttpStatus.OK);
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
