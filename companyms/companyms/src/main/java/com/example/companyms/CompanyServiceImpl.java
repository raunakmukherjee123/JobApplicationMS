package com.example.companyms;

import com.example.companyms.dto.CompanyDTO;
import com.example.companyms.dto.ReviewMessage;
import com.example.companyms.exceptions.CompanyNotFoundExceptions;
import com.example.companyms.feign_client.ReviewClient;
import com.example.companyms.projections.CompanyProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final ReviewClient reviewClient;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Integer id,Company updatedCompany) {
      return companyRepository.findById(id)
               .map(company->{
                   company.setDescription(updatedCompany.getDescription());
                   company.setName(updatedCompany.getName());

                   companyRepository.save(company);
                   return true;
               }).orElse(false);
    }

    @Override
    public Company create(CompanyDTO companyDTO) {
        Company company=new Company();

        company.setName(companyDTO.getName());
        company.setDescription(companyDTO.getDescription());

        Company savedCompany=companyRepository.save(company);
        return savedCompany;
    }

    @Override
    public boolean delete(Integer id) {
        if(companyRepository.existsById(id))
        {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CompanyProjection getById(Integer id) {
        CompanyProjection companyProjection= companyRepository.findCompanyById(id);

        if(companyProjection==null)
        {
            throw new CompanyNotFoundExceptions("No company found");
        }

        return companyProjection;
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        Company company = companyRepository.findById(reviewMessage.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found of this id:" + reviewMessage.getCompanyId()));

        Double averageRating = reviewClient.getAverageRating(company.getId());

        company.setAverageRating(averageRating);

        companyRepository.save(company);
    }
}
