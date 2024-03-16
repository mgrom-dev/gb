package ru.geekbrains.oop.lesson3.task2;

/**
 * Фрилансер (работник с почасовой оплатой)
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee {

    private Freelancer(String surName, String name, int age, double salary) {
        super(surName, name, age, salary);
    }

    public static Freelancer create(String surName, String name, int age, double salary){
        return new Freelancer(surName, name, age, salary);
    }

    @Override
    public double calculateSalary() {
        return 20.8 * 8 * salary;
    }

    @Override
    public String toString() {
        int mL = EmployeeFabric.nameLengthMax + EmployeeFabric.surnameLengthMax + 1;
        return String.format("%-10s: %-"+ mL + "s; Возраст: %-2d ; ставка: %,-10.2f руб.; заработная плата: %,-10.2f руб.",
            "Фрилансер", surName + " " + name, age, salary, calculateSalary());
    }
}
