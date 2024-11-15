package pro.sky.employee_book3;

public interface DepartmentService {

    Employee findEmployeeMaxSalary (Integer department);
    Employee findEmployeeMinSalary (Integer department);
    Employee allInDepartment (Integer department);
    Employee all (Integer department);

}
