package ru.geekbrains.oop.lesson2.task1;

public class Dog extends Animal{

    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Dog(String name, double weight) {
        super(name);
        this.weight = weight;
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Собака лает");
    }

    @Override
    public void jump() {
        System.out.println("Собака прыгает");
    }
}
