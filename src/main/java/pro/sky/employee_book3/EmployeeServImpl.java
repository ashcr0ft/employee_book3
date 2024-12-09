package pro.sky.employee_book3;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.employee_book3.Exeptions.EmployeeAlreadyAddedException;
import pro.sky.employee_book3.Exeptions.EmployeeNotFound;
import pro.sky.employee_book3.Exeptions.InvalidInputExeption;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServImpl implements EmployeeServ {

    private static Map<String, Employee> employees = new HashMap<>();

    private static String generateKey(String surname, String firstName, String patronymic) {
        return surname + " " + firstName + " " + patronymic;
    }

    @Override
    public Employee createEmployee(String surname, String firstName, String patronymic, Integer department, Integer salary) {
        validateName(surname, firstName, patronymic);
        Employee employee = new Employee(surname, firstName, patronymic, department, salary);
        String key = generateKey(surname, firstName, patronymic);
        if (!employees.containsKey(key)) {
            employees.put(key, employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }


    }


    @Override
    public Employee deleteEmployee(String surname, String firstName, String patronymic) {
        validateName(surname, firstName, patronymic);
        String key = generateKey(surname, firstName, patronymic);
        if (employees.containsKey(key)) {
            Employee employee = employees.get(key);
            employees.remove(key);
            return employee;
        } else {
            throw new EmployeeNotFound("Сотрудник не найден");
        }
    }

    @Override
    public Employee findEmployee(String surname, String firstName, String patronymic) {
        validateName(surname, firstName, patronymic);
        String key = generateKey(surname, firstName, patronymic);
        if (employees.containsKey(key)) {
            return employees.get(key);
        } else {
            throw new EmployeeNotFound("Сотрудник не найден");
        }
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private void validateName(String surname, String firstName, String patronymic) {
        if (!(StringUtils.isAlpha(surname) || StringUtils.isAlpha(firstName) || StringUtils.isAlpha(patronymic))) {
            throw new InvalidInputExeption();
        }
    }

}
