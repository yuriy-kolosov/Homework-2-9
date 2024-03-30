package pro.sky.homework29.service;

import pro.sky.homework29.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    String addEmployee(String firstName, String lastName, int salary, String departmentId);

    String findEmployee(String firstName, String lastName, String departmentId);

    String removeEmployee(String firstName, String lastName, String departmentId);

    Collection<Employee> findAll();

}