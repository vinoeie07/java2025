package com.viniv.boot.demo.service;

import com.viniv.boot.demo.EmployeeRepo;
import com.viniv.boot.demo.entity.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

    final EmployeeRepo employeeRepo;

    public void save(List<Employee> employee) {
        employeeRepo.saveAll(employee);
    }

    public List<Employee> getAll() {
        List<Employee> all = employeeRepo.findAll();
        return all;
        /*Stream<Employee> stream = all.stream().filter(emp -> emp.getEmployeeName().contains("Shree"));

        Map<String, Long> result =
                all.stream().collect(
                        Collectors.groupingBy(
                                Employee::getEmployeeName, Collectors.counting()
                        )
                );
        log.info("Grouping by shree : {}", result);

        log.info("filter that contains shree : {} ", stream.toList());

        Stream<Employee> streamSort = all.stream()
                .sorted(Comparator.comparing(Employee::getEmployeeName)
                        .thenComparingInt(Employee::getEmployeeId));

        Map<String, Employee> mapEmployee = new HashMap<>();
        Stream<Employee> employeeStream = streamSort.map(employee -> mapEmployee.put(employee.getEmployeeName(), employee));
        mapEmployee.forEach((key, value) -> log.info("map {} ====> {}", key, value));


        return employeeStream.toList();*/
    }


}
