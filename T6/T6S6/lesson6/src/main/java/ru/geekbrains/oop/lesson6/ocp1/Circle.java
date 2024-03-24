package ru.geekbrains.oop.lesson6.ocp1;

public class Circle implements Shape{

    private final int radius;

    public int getRadius() {
        return radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
