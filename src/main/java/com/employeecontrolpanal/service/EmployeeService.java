package com.employeecontrolpanal.service;

import com.employeecontrolpanal.entity.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> findAll();
        Employee findById(int id);
        Employee save(Employee employee);
        void deleteById(int id);
        void updateEmployee(Employee employee);
}
