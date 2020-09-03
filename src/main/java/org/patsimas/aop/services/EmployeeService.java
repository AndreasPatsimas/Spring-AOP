package org.patsimas.aop.services;

import org.patsimas.aop.models.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public Employee createEmployee(String empId, String fname, String sname) {

        return Employee.builder()
                .empId(empId)
                .firstName(fname)
                .secondName(sname)
                .build();
    }

    public void deleteEmployee(String empId) {
        System.out.println(empId);
    }
}
