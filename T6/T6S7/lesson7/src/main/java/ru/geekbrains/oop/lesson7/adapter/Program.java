package ru.geekbrains.oop.lesson7.adapter;

public class Program {

    public static void main(String[] args) {
        MeteoStore meteoDb = new MeteoStore();


        SensorTemperature st500_1 = new ST500();
        MeteoSensor ms200_1 = new MS200();
        meteoDb.save(ms200_1);
        meteoDb.save(new AdapterST500(st500_1));
    }

}
