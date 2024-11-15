package pro.sky.employee_book3;

import java.util.Collection;

public interface EmployeeServ {
    Employee createEmployee(String surname, String firstName, String patronymic, Integer department, Integer salary);

    Employee deleteEmployee(String surname, String firstName, String patronymic);

    Employee findEmployee(String surname, String firstName, String patronymic);

    Collection<Employee> getAll();
}
