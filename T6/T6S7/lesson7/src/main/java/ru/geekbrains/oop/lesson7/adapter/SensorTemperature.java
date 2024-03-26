package ru.geekbrains.oop.lesson7.adapter;

public interface SensorTemperature {

    int getIdentifier(); // Уникальный идентификатор датчика

    double temperature(); // Средняя температура

}
