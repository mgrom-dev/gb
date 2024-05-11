package ru.home;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // создаем сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Bob", LocalDate.of(2022, 2, 1)));
        employees.add(new Employee("Alice", LocalDate.of(2022, 1, 1)));
        employees.add(new Employee("David", LocalDate.of(2022, 4, 1)));
        employees.add(new Employee("Charlie", LocalDate.of(2022, 3, 1)));
        employees.add(new Employee("Emma", LocalDate.of(2022, 5, 1)));
        employees.add(new Employee("Frank", LocalDate.of(2022, 6, 1)));
        employees.add(new Employee("George", LocalDate.of(2022, 7, 1)));
        employees.add(new Director("Huston", LocalDate.of(2022, 8, 1)));

        // сортируем по дате приема
        Collections.sort(employees, Employee.hireDateComparator());
        // увеличиваем зарплату сотрудникам
        Director.increaseSalary(employees, 20);

        // Выводим отсортированный список сотрудников
        for (Employee employee : employees) {
            System.out.printf("%-8s: %10s; %3d руб.\n", employee.getName(), employee.getHireDate(), employee.getSalary());
        }
    }
}