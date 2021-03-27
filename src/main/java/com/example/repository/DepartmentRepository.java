package com.example.repository;

import com.example.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long>, JpaSpecificationExecutor<Department> {

    Page<Department> findAll(Specification<Department> specification, Pageable pageable);
}
