package ru.home;

import java.time.LocalDate;
import java.util.List;

/**
 * Опишите класс руководителя, наследник от сотрудника. Перенесите статический
 * метод повышения зарплаты в класс руководителя, модифицируйте метод таким
 * образом, чтобы он мог поднять заработную плату всем, кроме руководителей. В
 * основной программе создайте руководителя и поместите его в общий массив
 * сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата
 * руководителя не повысилась.
 */

public class Director extends Employee {

    public Director(String name, LocalDate hireDate) {
        super(name, hireDate);
    }

    // Переопределение статического метода повышения зарплаты
    public static void increaseSalary(List<Employee> employees, double percentage) {
        for (Employee employee : employees) {
            if (!(employee instanceof Director)) { // Проверяем, что сотрудник не является руководителем
                int currentSalary = employee.getSalary();
                int newSalary = (int)(currentSalary * (1 + percentage / 100));
                employee.setSalary(newSalary);
            }
        }
    }
}
