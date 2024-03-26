package ru.geekbrains.oop.lesson7.factory;

public class Program {

    public static void main(String[] args) {
        for (Employee e : EmployeeFactory.generateEmployees(25)){
            System.out.println(e);
        }
    }
}
