package com.employeecontrolpanal.controller;

import com.employeecontrolpanal.entity.Employee;
import com.employeecontrolpanal.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
     @GetMapping("/list")
    public String getEmployeeList(Model model) {
        List<Employee> employees = service.findAll();
        model.addAttribute("employees", employees);
        return "list_employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee_form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId")int id, Model model) {
        Employee employee = service.findById(id);
        System.out.println("Employee ID: " + employee);
        model.addAttribute("employee", employee);
        return "employee_form";
    }
    @GetMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        service.deleteById(id);
        return "redirect:/employees/list";
    }

}
