package com.example.repository;

import com.example.entity.Employee3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Employee3Repository extends JpaRepository<Employee3, Long>, JpaSpecificationExecutor<Employee3> {
}
