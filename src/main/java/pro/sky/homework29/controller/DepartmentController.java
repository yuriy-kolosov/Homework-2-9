package pro.sky.homework29.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework29.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/all")
    public String findAllEmployeeAllDept() {
        return departmentService.findAllEmployeesFromAllDepartments();
    }

    @GetMapping(path = "/all", params = "departmentId")
    public String findEmployeeDept(@RequestParam("departmentId") String deptId) {
        return departmentService.findAllEmployeesFromDepartment(deptId);
    }

    @GetMapping(path = "/min-salary")
    public String findEmpDeptMinSalary(@RequestParam("departmentId") String deptId) {
        return departmentService.findEmployeeWithMinSalary(deptId);
    }

    @GetMapping(path = "/max-salary")
    public String findEmpDeptMaxSalary(@RequestParam("departmentId") String deptId) {
        return departmentService.findEmployeeWithMaxSalary(deptId);
    }

}