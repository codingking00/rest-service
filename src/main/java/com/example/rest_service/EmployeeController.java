package com.example.rest_service;


 
import java.net.URI;
import java.util.List;

import org.springframework.beans 
    .factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind 
    .annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind
    .annotation.RequestMapping;
import org.springframework.web.bind
    .annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping( path = "", produces = "application/json")
    public List<Employee> getEmployees()
    { 
  
        return employeeManager.getAllEmployees(); 
    }

    @PostMapping( 
        path = "", 
        consumes = "application/json",
        produces = "application/json")
  
    public ResponseEntity<Object> addEmployee(
        @RequestBody Employee employee) 
    { 

        // Creating an ID of an employee 
        // from the number of employees 
        Integer id 
            = employeeManager 
                  .getAllEmployees() 
                  .size() 
              + 1; 
  
        employee.setId(id); 
        
  
        employeeManager.addEmployees(employee);
  
        URI location 
            = ServletUriComponentsBuilder 
                  .fromCurrentRequest() 
                  .path("/{id}") 
                  .buildAndExpand( 
                      employee.getId()) 
                  .toUri(); 
  
               return ResponseEntity 
            .created(location) 
            .build(); 
    }


}
