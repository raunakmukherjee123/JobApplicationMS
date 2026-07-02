package com.example.companyms;

import com.example.companyms.dto.CompanyDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController
{
    private final CompanyService companyService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllCompany()
    {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody Company updatedCompany)
    {
        boolean f=companyService.updateCompany(id,updatedCompany);
        if(f)
        {
            return new ResponseEntity<>("Updated company",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("No company found with id = "+id,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CompanyDTO companyDTO)
    {
        return new ResponseEntity<>(companyService.create(companyDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/create/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id)
    {
        boolean isDeleted= companyService.delete(id);

        if(isDeleted)
        {
            return new ResponseEntity<>("Deleted Succesfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("No company found of this id",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCompany(@PathVariable("id") Integer id) {
        Company company = companyService.getById(id);

//        if (company != null) {
//            return new ResponseEntity<>(company, HttpStatus.OK);
//        }
            return new ResponseEntity<>(company, HttpStatus.OK);


       // return new ResponseEntity<>("No company found", HttpStatus.NOT_FOUND);
    }
}
