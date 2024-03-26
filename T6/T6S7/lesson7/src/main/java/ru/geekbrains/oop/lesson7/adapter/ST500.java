package ru.geekbrains.oop.lesson7.adapter;

import java.util.Random;

public class ST500 implements SensorTemperature {


    int id;
    private Random random = new Random();

    public ST500(){
        id = random.nextInt(50001, 60000);
    }

    @Override
    public int getIdentifier() {
        return id;
    }

    @Override
    public double temperature() {
        return 30.1;
    }
}
