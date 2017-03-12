package com.example.about.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UniversityRepository extends CrudRepository<University, Long> {
}
