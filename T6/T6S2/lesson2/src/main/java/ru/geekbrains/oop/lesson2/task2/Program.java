package ru.geekbrains.oop.lesson2.task2;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        Runnable cat = new Cat();
        Runnable dog = new Dog();

        ArrayList<Runnable> list = new ArrayList<>();
        list.add(cat);
        list.add(dog);

        for (Runnable runner : list){
            runner.run();
        }
    }

}
