package org.patsimas.aop.controllers;

import org.patsimas.aop.models.Employee;
import org.patsimas.aop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add/employee/{empId}/{firstName}/{secondName}")
    public Employee addEmployee(@PathVariable("empId") String empId, 
                                @PathVariable("firstName") String firstName, 
                                @PathVariable("secondName") String secondName) {
        return employeeService.createEmployee(empId, firstName, secondName);
    }

    @GetMapping("/remove/employee/{empId}")
    public String removeEmployee( @PathVariable("empId") String empId) {
        employeeService.deleteEmployee(empId);
        return "Employee removed";
    }
}
