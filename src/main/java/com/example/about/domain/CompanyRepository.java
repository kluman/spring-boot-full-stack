package com.example.about.domain;

import org.springframework.data.repository.CrudRepository;
import com.example.about.domain.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
