package pro.sky.employee_book3;

public interface EmployeeServ {
    Employee createEmployee(String surname, String firstName, String patronymic);

    Employee deleteEmployee(String surname, String firstName, String patronymic);

    Employee findEmployee(String surname, String firstName, String patronymic);

    String getAll();
}
