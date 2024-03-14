package ru.geekbrains.oop.lesson2.home;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.printf("В тарелке: %d еды\n", food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
        if (food < 0) this.food = 0;
    }

    // добавление еды в тарелку
    public void addFood(int food) {
        if (food > 0)
        this.food += food;
    }
}