package com.example.repository;

import com.example.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChildRepository extends JpaRepository<Child, Long>, JpaSpecificationExecutor<Child>  {
}
