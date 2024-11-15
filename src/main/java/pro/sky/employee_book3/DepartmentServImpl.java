package pro.sky.employee_book3;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServImpl implements DepartmentService {
    private final EmployeeServ employeeService;
    public DepartmentServImpl(EmployeeServ employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee> findEmployeeMaxSalary(Integer department) {
        return employeeService.getAll().stream().filter(e->e.getDepartment().equals(department)).max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> findEmployeeMinSalary(Integer department) {
        return employeeService.getAll().stream().filter(e->e.getDepartment().equals(department)).min(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public List<Employee> allInDepartment(Integer department) {
        return employeeService.getAll().stream().filter(e->e.getDepartment().equals(department)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> all() {
        return employeeService.getAll().stream().toList();
    }
}
