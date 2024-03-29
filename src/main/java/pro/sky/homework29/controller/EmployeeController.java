package pro.sky.homework29.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework29.service.EmployeeService;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/addEmployee")
    public String add(@RequestParam("firstName") String fName,
                      @RequestParam("lastName") String lName,
                      @RequestParam("salary") int salary,
                      @RequestParam("departmentId") String deptId) {
        return employeeService.addEmployee(fName, lName, salary, deptId);
    }

    @GetMapping(path = "/findEmployee")
    public String findEmp(@RequestParam("firstName") String fName,
                          @RequestParam("lastName") String lName,
                          @RequestParam("departmentId") String deptId) {
        return employeeService.findEmployee(fName, lName, deptId);
    }

    @GetMapping(path = "/removeEmployee")
    public String remove(@RequestParam("firstName") String fName,
                         @RequestParam("lastName") String lName,
                         @RequestParam("departmentId") String deptId) {
        return employeeService.removeEmployee(fName, lName, deptId);
    }

    @GetMapping(path = "/departments/all")
    public String findAll() {
        return employeeService.findAllEmployeesFromAllDepartments();
    }

    @GetMapping(path = "/department/all")
    public String findEmpDept(@RequestParam("departmentId") String deptId) {
        return employeeService.findAllEmployeesFromDepartment(deptId);
    }

    @GetMapping(path = "/departments/min-salary")
    public String findEmpDeptMinSal(@RequestParam("departmentId") String deptId) {
        return employeeService.findEmployeeWithMinSalary(deptId);
    }

    @GetMapping(path = "/departments/max-salary")
    public String findEmpDeptMaxSal(@RequestParam("departmentId") String deptId) {
        return employeeService.findEmployeeWithMaxSalary(deptId);
    }

}