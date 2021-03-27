package com.example.service;

import com.example.dto.EmployeeDTO;
import com.example.mapper.EmployeeMapper;
import com.example.repository.EmployeeRepository;
import com.example.specification.EmployeeSpecification;
import com.example.specification.filter.EmployeeSearchCriteria;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @NonNull
    private EmployeeRepository repository;

    public List<EmployeeDTO> getEmployees(EmployeeSearchCriteria filter) {
        return repository.findAll(EmployeeSpecification.toSpecification(filter), Sort.by(Sort.Direction.ASC, "department.name"))
                .stream().map(EmployeeMapper::toDTO).collect(Collectors.toList());
    }
}
