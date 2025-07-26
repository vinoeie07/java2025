package com.viniv.boot.demo.controller;

import com.viniv.boot.demo.config.ApplicationConfig;
import com.viniv.boot.demo.entity.Employee;
import com.viniv.boot.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    final EmployeeService employeeService;
    final ApplicationConfig applicationConfig;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveEmployee() {
        log.info("save employee");
        List<Employee> list = getEmployees();
        employeeService.save(list);
    }

    private List<Employee> getEmployees() {
        Employee emp = new Employee();
        emp.setEmployeeName("Vinodkumar");
        emp.setEmployeeId(7686);
        emp.setCompany(applicationConfig.getCompany());
        emp.setCompany(applicationConfig.getBranch());

        Employee emp1 = new Employee();
        emp1.setEmployeeName("Nivedha");
        emp1.setEmployeeId(240990);
        emp1.setCompany(applicationConfig.getCompany());
        emp1.setCompany(applicationConfig.getBranch());

        Employee emp2 = new Employee();
        emp2.setEmployeeName("Chetnaa Shree");
        emp2.setEmployeeId(231017);
        emp2.setCompany(applicationConfig.getCompany());
        emp2.setCompany(applicationConfig.getBranch());

        Employee emp3 = new Employee();
        emp3.setEmployeeName("Meghnaa Shree");
        emp3.setEmployeeId(131020);
        emp3.setCompany(applicationConfig.getCompany());
        emp3.setCompany(applicationConfig.getBranch());

        return Arrays.asList(emp, emp1, emp2, emp3);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAll());
    }
}
