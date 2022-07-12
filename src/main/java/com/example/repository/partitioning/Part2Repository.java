package com.example.repository.partitioning;

import com.example.entity.partitioning.Part2;
import com.example.entity.partitioning.Part2PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Part2Repository extends JpaRepository<Part2, Part2PK>, JpaSpecificationExecutor<Part2> {
}
