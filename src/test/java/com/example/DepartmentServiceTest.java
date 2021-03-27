package com.example;

import com.example.dto.DepartmentDTO;
import com.example.entity.Department;
import com.example.repository.DepartmentRepository;
import com.example.service.DepartmentService;
import com.example.specification.filter.DepartmentSearchCriteria;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService serviceMock;

    @Mock
    private DepartmentRepository repositoryMock;

    private static final Integer page = 0;
    private static final Integer size = 1;

    private List<Department> departments;
    private List<DepartmentDTO> returnDTOs;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);

        departments = List.of(mock(Department.class));
        returnDTOs = List.of(new DepartmentDTO(0l, null, null));
    }

    @Test
    public void testGetDepartmentList() {
        Pageable pageRequest = PageRequest.of(page, size);
        when(repositoryMock.findAll(any(Specification.class), eq(pageRequest)))
                .thenReturn(new PageImpl<Department>(departments, pageRequest, 1));

        assertEquals(returnDTOs, serviceMock.getDepartmentList(new DepartmentSearchCriteria(), page, size));
    }

    @Test(expected = NullPointerException.class)
    public void testGetDepartmentListError() {
        serviceMock.getDepartmentList(null, page, size);
    }
}
