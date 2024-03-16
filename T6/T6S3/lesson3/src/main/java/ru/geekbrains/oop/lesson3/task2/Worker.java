package ru.geekbrains.oop.lesson3.task2;


/**
 * Рабочий (работает с 9 до 18,
 * получает фиксированную заработную плату)
 */
public class Worker extends Employee {
    private Worker(String surName, String name, int age, double salary) {
        super(surName, name, age, salary);
    }

    public static Worker create(String surName, String name, int age, double salary){
        return new Worker(surName, name, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        int mL = EmployeeFabric.nameLengthMax + EmployeeFabric.surnameLengthMax + 1;
        return String.format("%-10s: %-"+ mL + "s; Возраст: %-2d ; ставка: %,-10.2f руб.; заработная плата: %,-10.2f руб.",
            "Рабочий", surName + " " + name, age, salary, calculateSalary());
    }
}
