package com.example.springdatarest.repository;

import com.example.springdatarest.entity.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
}
