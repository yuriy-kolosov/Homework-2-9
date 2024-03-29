package pro.sky.homework29.service;

public interface EmployeeService {

    String addEmployee(String firstName, String lastName, int salary, String departmentId);

    String findEmployee(String firstName, String lastName, String departmentId);

    String removeEmployee(String firstName, String lastName, String departmentId);

    String findAllEmployeesFromAllDepartments();

    String findAllEmployeesFromDepartment(String departmentId);

    String findEmployeeWithMinSalary(String departmentId);

    String findEmployeeWithMaxSalary(String departmentId);

}