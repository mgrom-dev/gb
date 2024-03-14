package ru.geekbrains.oop.lesson2.task2;

public class Cat extends BaseCat implements Runnable {
    @Override
    public void run() {
        System.out.println("Котик бежит");
    }
}
