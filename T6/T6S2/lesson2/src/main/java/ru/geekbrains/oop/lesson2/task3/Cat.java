package ru.geekbrains.oop.lesson2.task3;

import ru.geekbrains.oop.lesson2.task2.BaseCat;

public class Cat extends BaseCat implements Runner {

    private String name;
    private int maxRun;
    private int maxJump;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    public Cat(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

}
