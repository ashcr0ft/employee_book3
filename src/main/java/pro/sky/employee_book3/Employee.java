package pro.sky.employee_book3;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private final String surname;
    private final String firstName;
    private final String patronymic;
    private final Integer department;
    private final Integer salary;

    public Employee(String surname, String firstName, String patronymic, Integer department, Integer salary) {
        this.surname = StringUtils.capitalize(surname.toLowerCase());
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.patronymic = StringUtils.capitalize(patronymic.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public Integer getDepartment() {
        return this.department;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(surname, employee.surname) && Objects.equals(firstName, employee.firstName) && Objects.equals(patronymic, employee.patronymic) && Objects.equals(department, employee.department) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, firstName, patronymic, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
