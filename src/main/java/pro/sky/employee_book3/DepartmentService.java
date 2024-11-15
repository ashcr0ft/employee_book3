package pro.sky.employee_book3;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Optional<Employee> findEmployeeMaxSalary (Integer department);
    Optional<Employee> findEmployeeMinSalary (Integer department);
    List<Employee> allInDepartment (Integer department);
    List<Employee> all ();

}
