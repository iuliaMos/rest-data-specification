package com.example.repository;

import com.example.entity.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepEmplRepository extends JpaRepository<Employee2, Long>, JpaSpecificationExecutor<Employee2> {

    @Query("SELECT a from Employee a")
    List<Employee2> findByMyCondition();
}
