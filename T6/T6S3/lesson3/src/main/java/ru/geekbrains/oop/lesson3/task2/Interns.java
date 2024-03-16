package ru.geekbrains.oop.lesson3.task2;

public class Interns extends Employee  {

    private int hoursWorked; // количество отработанных часов

    private Interns(String surName, String name, int age, double salary) {
        super(surName, name, age, salary);
        this.hoursWorked = 0;
    }

    public static Interns create(String surName, String name, int age, double salary, int hoursWorked){
        Interns newInterns = new Interns(surName, name, age, salary);
        newInterns.hoursWorked = hoursWorked;
        return newInterns;
    }

    @Override
    public double calculateSalary() {
        return salary * hoursWorked;
    }

    @Override
    public String toString() {
        int mL = EmployeeFabric.nameLengthMax + EmployeeFabric.surnameLengthMax + 1;
        return String.format("%-10s: %-"+ mL + "s; Возраст: %-2d ; ставка: %,-10.2f руб.; заработная плата: %,-10.2f руб.",
                "Студент", surName + " " + name, age, salary, calculateSalary());
    }
}
