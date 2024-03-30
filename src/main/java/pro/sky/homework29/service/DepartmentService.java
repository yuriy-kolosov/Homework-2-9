package pro.sky.homework29.service;

public interface DepartmentService {

    String findAllEmployeesFromAllDepartments();

    String findAllEmployeesFromDepartment(String departmentId);

    String findEmployeeWithMinSalary(String departmentId);

    String findEmployeeWithMaxSalary(String departmentId);

}