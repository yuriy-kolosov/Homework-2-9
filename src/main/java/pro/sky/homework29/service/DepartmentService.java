package pro.sky.homework29.service;

import pro.sky.homework29.model.Employee;

import java.util.Collection;

public interface DepartmentService {

    Collection<Employee> findAllEmployeesFromAllDepartments();

    Collection<Employee> findAllEmployeesFromDepartment(String departmentId);

    Employee findEmployeeWithMinSalary(String departmentId);

    Employee findEmployeeWithMaxSalary(String departmentId);

}