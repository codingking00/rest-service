package com.example.rest_service;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    EmployeeManager employeeManager;

    Employee employee_1 =new Employee(10,"q","w","e","r");
    Employee employee_2 =new Employee(11,"p","o","i","u");
    Employee employee_3 =new Employee(12,"h","j","k","l");
    
@Test
public void getAllEmployees_success() throws Exception{
    List<Employee> employees=new ArrayList<>(Arrays.asList(employee_1,employee_2,employee_3));

    

    when(employeeManager.getAllEmployees()).thenReturn(employees);

    mockMvc.perform(MockMvcRequestBuilders
            .get("/employees")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].firstName", is("q")))
            .andExpect(jsonPath("$[1].id").value(11))
            .andExpect(jsonPath("$[2].id").value(12));

}

}
