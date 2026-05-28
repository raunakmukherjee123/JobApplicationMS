package com.example.jobms;

import com.example.jobms.feign_client.CompanyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{
//    private List<Job> jobs=new ArrayList<>();

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;
    private final CompanyClient companyClient;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void create(Job job) {
      jobRepository.save(job);
    }

    @Override
    public JobDto findJobById(Integer id) {
        Job job = jobRepository.findById(id).orElse(null);

        ResponseEntity<Company> company=companyClient.getCompany(job.getCompanyId());

        return jobMapper.JobToJobDto(job,company.getBody());
    }

    @Override
    public boolean deteteJobById(Integer id) {
       try {
           jobRepository.deleteById(id);
           return true;
       } catch (Exception e) {
           return false;
       }
    }

    @Override
    public boolean updateJob(Integer id, Job updatedjob) {
        Optional<Job> jobOptional=jobRepository.findById(id);

            if(jobOptional.isPresent())
            {
                Job job=jobOptional.get();

                job.setDescription(updatedjob.getDescription());
                job.setLocation(updatedjob.getLocation());
                job.setTitle(updatedjob.getTitle());
                job.setMaxSalary(updatedjob.getMaxSalary());
                job.setMinSalary(updatedjob.getMinSalary());

                jobRepository.save(job);
                return true;
            }
        return false;
    }
}
