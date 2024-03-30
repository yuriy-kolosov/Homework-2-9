package pro.sky.homework29.service;

import org.springframework.stereotype.Service;
import pro.sky.homework29.model.Employee;

import java.util.Comparator;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String findAllEmployeesFromDepartment(String departmentId) {

        return employeeService.findAll().stream()
                .filter(p -> (p.getDepartmentId().equals(departmentId)))
                .toList()
                .toString();

    }

    @Override
    public String findAllEmployeesFromAllDepartments() {

        return employeeService.findAll().stream()
                .toList()
                .toString();

    }

    public String findEmployeeWithMinSalary(String departmentId) {

        final Optional<Employee> employeeDetected = employeeService.findAll().stream()
                .filter(p -> (p.getDepartmentId().equals(departmentId)))
                .min(Comparator.comparingInt(e -> e.getSalary()));

        return employeeDetected.orElseThrow().toString();

    }

    public String findEmployeeWithMaxSalary(String departmentId) {

        final Optional<Employee> employeeDetected = employeeService.findAll().stream()
                .filter(p -> (p.getDepartmentId().equals(departmentId)))
                .max(Comparator.comparingInt(e -> e.getSalary()));

        return employeeDetected.orElseThrow().toString();

    }

}