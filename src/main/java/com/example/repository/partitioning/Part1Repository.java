package com.example.repository.partitioning;

import com.example.entity.partitioning.Part1;
import com.example.entity.partitioning.Part1PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface Part1Repository extends JpaRepository<Part1, Part1PK>, JpaSpecificationExecutor<Part1> {

    @Query(value = "select count(1) from part1_part2", nativeQuery = true)
    Long findManyToManyCount();
}
