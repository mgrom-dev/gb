package ru.geekbrains.oop.lesson3.task2;

import java.util.Arrays;

/**
 * Доработать приложение, которое мы разрабатывали на уроке. Мы доллжны
 * поработать с сортировкой объектов, освоить работу с интерфейсами Comparator,
 * Comparable.
 * 
 * 1. Доработать класс Freelancer, при желании можно разработать и свой
 * собтственный тип сотрудника. Формула расчета среднемесячной заработной платы
 * может быть такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая
 * ставка»
 * 2. Переработать метод generateEmployees, метод должен создавать случайного
 * сотрудника (Worker, Freelancer или любого другого). Метод должен быть один!
 * 3. Придумать свой собственный компаратор (Возможно отсортировать сотрудников по
 * возрасту? Тогда добавьте соответствующее состояние на уровне ваших классов).
 * 4. Продемонстрировать сортировку объектов различного типа с использованием
 * собственного компаратора.
 */

public class Program {

    public static void main(String[] args) {

        Employee[] workers = EmployeeFabric.generateEmployees(15);
        for (Employee worker : workers) {
            System.out.println(worker);
        }

        Arrays.sort(workers/* , new SalaryComparator() */);

        System.out.println();
        System.out.println("***");
        System.out.println();

        for (Employee worker : workers) {
            System.out.println(worker);
        }

        // сортировка по возрасту
        System.out.println();
        System.out.println("***\nСортировка по возрасту");
        System.out.println();

        Arrays.sort(workers, new AgeComparator());

        for (Employee worker : workers) {
            System.out.println(worker);
        }
    }

}
