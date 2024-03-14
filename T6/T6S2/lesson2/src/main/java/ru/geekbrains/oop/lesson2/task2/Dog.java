package ru.geekbrains.oop.lesson2.task2;

public class Dog extends BaseDog implements Runnable {
    @Override
    public void run() {
        System.out.println("Собака бежит");
    }
}
