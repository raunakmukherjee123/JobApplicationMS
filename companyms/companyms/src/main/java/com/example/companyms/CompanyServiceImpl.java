package com.example.companyms;

import com.example.companyms.dto.ReviewMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

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
    public Company create(Company company) {
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
    public Company getById(Integer id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {

    }
}
