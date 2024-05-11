package ru.home;

import java.time.LocalDate;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий
 * две даты, представленные в виде трёх чисел гггг-мм-дд, без использования
 * условного оператора.
 */

@AllArgsConstructor
@Data
public class Employee {
    private int salary;
    private String name;
    private LocalDate hireDate;

    // по умолчанию зарплата 100
    public Employee(String name, LocalDate hirDate) {
        this(100, name, hirDate);
    }

    // Прототип компаратора для сравнения дат найма сотрудников
    public static Comparator<Employee> hireDateComparator() {
        return Comparator.comparing(Employee::getHireDate);
    }

    public static void increaseSalary(Employee employee, int value) {
        employee.salary += value;
    }
}
