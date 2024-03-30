package pro.sky.homework29.service;

import org.springframework.stereotype.Service;
import pro.sky.homework29.exception.EmployeeAlreadyAddedException;
import pro.sky.homework29.exception.EmployeeNotFoundException;
import pro.sky.homework29.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //                                                      Домашнее задание 2-9. Stream API и Optional
    Map<String, Employee> employeeBook;

    public EmployeeServiceImpl() {
        this.employeeBook = new HashMap<>();
    }

    public String addEmployee(String firstName, String lastName, int salary, String departmentId) {

        Employee e = new Employee(firstName, lastName, salary, departmentId);

        if (employeeBook.containsKey(e.getFullNameAndDepartmentId())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employeeBook.put(e.getFullNameAndDepartmentId(), e);
            return "Сотрудник " + firstName + " " + lastName + " добавлен, отдел номер " + departmentId;
        }
    }

    public String removeEmployee(String firstName, String lastName, String departmentId) {

        String fE = firstName + lastName + departmentId;

        final Optional<Employee> employeeDetected = employeeBook.values().stream()
                .filter(e -> e.getFullNameAndDepartmentId().equals(fE))
                .findAny();

        if (employeeDetected.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else {
            employeeBook.remove(employeeDetected.get().getFullNameAndDepartmentId(), employeeDetected.get());
            return "Сотрудник " + firstName + " " + lastName + " удален, отдел номер " + departmentId;
        }

    }

    public String findEmployee(String firstName, String lastName, String departmentId) {

        String fE = firstName + lastName + departmentId;

        final Optional<String> employeeDetected = employeeBook.values().stream()
                .filter(e -> e.getFullNameAndDepartmentId().equals(fE))
                .map(s -> "Найден: " + s)
                .findFirst();

        return employeeDetected.orElseThrow(() -> new EmployeeNotFoundException());

    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeeBook.values());
    }

}