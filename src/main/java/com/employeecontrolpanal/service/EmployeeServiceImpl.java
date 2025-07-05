package com.employeecontrolpanal.service;

import com.employeecontrolpanal.dao.EmployeeRepository;
import com.employeecontrolpanal.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
         return employeeRepository.findById(id).get();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee currentEmployee = employeeRepository.findById(employee.getId()).get();
        if (currentEmployee == null) {
            throw new RuntimeException("Employee not found with id: " + employee.getId());
        } else {
            currentEmployee.setFirstName(employee.getFirstName());
            currentEmployee.setLastName(employee.getLastName());
            currentEmployee.setEmail(employee.getEmail());
            employeeRepository.save(currentEmployee);
        }
    }
}
