package pro.sky.homework29.service;

import org.springframework.stereotype.Service;
import pro.sky.homework29.exception.EmployeeNotFoundException;
import pro.sky.homework29.model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Collection<Employee> findAllEmployeesFromDepartment(String departmentId) {

        return employeeService.findAll().stream()
                .filter(p -> (p.getDepartmentId().equals(departmentId)))
                .collect(toList());

    }

    @Override
    public Collection<Employee> findAllEmployeesFromAllDepartments() {

        return employeeService.findAll();

    }

    public Employee findEmployeeWithMinSalary(String departmentId) {

        final Optional<Employee> employeeDetected = employeeService.findAll().stream()
                .filter(p -> (p.getDepartmentId().equals(departmentId)))
                .min(Comparator.comparingInt(e -> e.getSalary()));

        return employeeDetected.orElseThrow(() -> new EmployeeNotFoundException());

    }

    public Employee findEmployeeWithMaxSalary(String departmentId) {

        final Optional<Employee> employeeDetected = employeeService.findAll().stream()
                .filter(p -> (p.getDepartmentId().equals(departmentId)))
                .max(Comparator.comparingInt(e -> e.getSalary()));

        return employeeDetected.orElseThrow(() -> new EmployeeNotFoundException());

    }

}