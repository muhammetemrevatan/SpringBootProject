package com.memrevatan.ui.rest;

import com.memrevatan.business.services.EmployeeServices;
import com.memrevatan.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping({"/index","/"})
    public String getRoot(){
        return "index";
    }

    // http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employeeServices.getAllEmployees();
        return employeeDtos;
    }

    // http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Throwable {
        ResponseEntity<EmployeeDto> employeeDto = employeeServices.getEmployeeById(id);
        return employeeDto;
    }

    // http://localhost:8080/api/v1/employees
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeServices.createEmployee(employeeDto);
        return employeeDto;
    }

    // http://localhost:8080/api/v1/employees
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
                                                      @RequestBody EmployeeDto employeeDto) throws Throwable {
        employeeServices.updateEmployee(id,employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        employeeServices.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
