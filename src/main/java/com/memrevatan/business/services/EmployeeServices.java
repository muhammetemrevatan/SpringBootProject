package com.memrevatan.business.services;

import com.memrevatan.data.entity.EmployeeEntity;
import com.memrevatan.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {

    //CRUD
    public List<EmployeeDto> getAllEmployees();

    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) throws Throwable;

    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) throws Throwable;

    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) throws Throwable;

    //modelMapper
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity);

    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto);
}
