package com.example.controller;

import com.example.dto.DepartmentDTO;
import com.example.dto.DepartmentModel;
import com.example.dto.EmployeeDTO;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import com.example.specification.filter.DepartmentSearchCriteria;
import com.example.specification.filter.EmployeeSearchCriteria;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

    @NonNull
    private EmployeeService employeeService;
    @NonNull
    private DepartmentService departmentService;

    @GetMapping("/employee")
    public List<EmployeeDTO> getEmployees(final EmployeeSearchCriteria filter) {
        log.info("Get Employees");
        return employeeService.getEmployees(filter);
    }

    @GetMapping("/department")
    public List<DepartmentDTO> getDepartments(@RequestParam(value = "page", required = false, defaultValue = "0") final Integer page,
                                              @RequestParam(value = "size", required = false, defaultValue = "10") final Integer size,
                                              final DepartmentSearchCriteria filter
    ) {
        log.info("Get Departments, {}", filter);
        return departmentService.getDepartmentList(filter, page, size);
    }

    @GetMapping("/department/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/department")
    public void saveDepartment(@Valid @RequestBody final DepartmentModel department) {
        log.info("save department {}", department);
        departmentService.save(department);
    }

}
