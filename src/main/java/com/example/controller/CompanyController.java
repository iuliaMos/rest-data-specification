package com.example.controller;

import com.example.dto.DepartmentDTO;
import com.example.dto.EmployeeDTO;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import com.example.specification.filter.DepartmentSearchCriteria;
import com.example.specification.filter.EmployeeSearchCriteria;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<EmployeeDTO> getEmployees(@RequestParam(value = "id", required = false) final Long id,
                                          @RequestParam(value = "name", required = false) final String name,
                                          @RequestParam(value = "department", required = false) final String department) {
        log.info("Get Employees");
        EmployeeSearchCriteria filter = new EmployeeSearchCriteria(id, name, department);
        return employeeService.getEmployees(filter);
    }

    @GetMapping("/department")
    public List<DepartmentDTO> getDepartments(@RequestParam(value = "page", required = false, defaultValue = "0") final Integer page,
                                              @RequestParam(value = "size", required = false, defaultValue = "10") final Integer size,
                                              @RequestParam(value = "id", required = false) final Long id,
                                              @RequestParam(value = "name", required = false) final String name
                                              ) {
        log.info("Get Departments");
        DepartmentSearchCriteria filter = new DepartmentSearchCriteria(id, name);
        return departmentService.getDepartmentList(filter, page, size);
    }
}
