package ru.home;

import lombok.Getter;

public class Cat extends Animal {
    private static int numerator;
    @Getter private int id;

    public Cat(String name) {
        super(name, "cat");
        Cat.numerator++;
        id = numerator;
    }
    
    @Override
    boolean swim(float barrier) {
        return false;
    }
}
