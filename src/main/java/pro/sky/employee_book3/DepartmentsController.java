package pro.sky.employee_book3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String hello() {
        return "Hello";
    }

    @GetMapping("/max-salary")
    public String maxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.findEmployeeMaxSalary(departmentId).toString();
    }

    @GetMapping("/min-salary")
    public String minSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.findEmployeeMinSalary(departmentId).toString();
    }

    @GetMapping("/all")
    public String all(@RequestParam(required = false, name = "departmentId") Integer departmentId) {
        if (departmentId == null) {
            return departmentService.all().toString();
        } else {

            return departmentService.allInDepartment(departmentId).toString();
        }
    }

}