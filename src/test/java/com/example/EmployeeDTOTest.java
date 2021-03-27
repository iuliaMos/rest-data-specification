package com.example;

import com.example.dto.EmployeeDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDTOTest {

    @Test
    public void testEmployeeDTO() {
        EmployeeDTO mockDTO = mock(EmployeeDTO.class);

        mockDTO.setDepartment(anyString());
        verify(mockDTO).setDepartment(anyString());

        when(mockDTO.getDepartment()).thenReturn("dep");
        assertEquals("dep", mockDTO.getDepartment());

        mockDTO.setId(1l);
        mockDTO.setId(1l);
        verify(mockDTO, times(2)).setId(1l);

        verify(mockDTO, never()).setAge(anyInt());
    }

}
