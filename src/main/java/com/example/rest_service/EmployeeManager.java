package com.example.rest_service;

import java.util.List;

import org.springframework.stereotype .Repository;


@Repository
public class EmployeeManager {
    private static Employees list = new Employees();
    static{
        list.getEmployeeList().add(new Employee(1,"Mengen","Li","woshidage@gmail.com","laoda"));
        list.getEmployeeList().add(new Employee(2,"Wenyi","Li","woailimengen@gmail.com","laoer"));
        list.getEmployeeList().add(new Employee(3,"Xiaobai","Li","woaibaba@gmail.com","laosan"));
        list.getEmployeeList().add(new Employee(4,"Hetao","Li","woaibaba@gmail.com","laosi"));

    }

    public List<Employee> getAllEmployees() {
        return list.getEmployeeList();
    }

    public void addEmployees(Employee person) {
        list.getEmployeeList().add(person);
    }


}
