package com.example.service;

import com.example.dto.DepartmentDTO;
import com.example.entity.Department;
import com.example.mapper.EmployeeMapper;
import com.example.repository.DepartmentRepository;
import com.example.specification.DepartmentSpecification;
import com.example.specification.filter.DepartmentSearchCriteria;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    @NonNull
    private DepartmentRepository repository;

    public List<DepartmentDTO> getDepartmentList(final DepartmentSearchCriteria filter, Integer page, Integer size) {
        Pageable pageRequest = PageRequest.of(page, size);
        Specification<Department> specification = DepartmentSpecification.toSpecification(filter);

        Page<Department> departments = repository.findAll(specification, pageRequest);

        return departments.getContent().stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

}
