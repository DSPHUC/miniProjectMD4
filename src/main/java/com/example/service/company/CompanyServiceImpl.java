package com.example.service.company;

import com.example.model.Company;
import com.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository
                .findAll()
               /* .stream()
                .map(
                        company -> new CompanyResponse(
                                company.getId().toString()
                                ,company.getName()))
                .collect(
                        Collectors
                                .toList())*/;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Company company) {

    }

    @Override
    public void update(Long id, Company company) {

    }
}
