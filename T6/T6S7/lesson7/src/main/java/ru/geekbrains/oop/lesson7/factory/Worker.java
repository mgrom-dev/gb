package ru.geekbrains.oop.lesson7.factory;

public class Worker extends Employee {
    private Worker(String name, String surName, double salary) {
        super(name, surName, salary);
    }

    public static Worker create(String name, String surName, double salary){

        if (name == null || name.length() < 3)
            throw new RuntimeException("Имя рабочего указано некорректно.");

        if (salary <= 0)
            throw new RuntimeException("Уровень заработной платы указан некорректно.");

        return new Worker(name, surName, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surName, name, salary);
    }
}
