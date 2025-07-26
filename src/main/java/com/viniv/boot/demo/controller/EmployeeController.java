package com.viniv.boot.demo.controller;

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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveEmployee() {
        log.info("save employee");
        List<Employee> list = getEmployees();
        employeeService.save(list);
    }

    private static List<Employee> getEmployees() {
        Employee emp = new Employee();
        emp.setEmployeeName("Vinodkumar");
        emp.setEmployeeId(7686);

        Employee emp1 = new Employee();
        emp1.setEmployeeName("Nivedha");
        emp1.setEmployeeId(240990);

        Employee emp2 = new Employee();
        emp2.setEmployeeName("Chetnaa Shree");
        emp2.setEmployeeId(231017);

        Employee emp3 = new Employee();
        emp3.setEmployeeName("Meghnaa Shree");
        emp3.setEmployeeId(131020);

        return Arrays.asList(emp, emp1, emp2, emp3);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAll());
    }
}
