package ru.geekbrains.oop.lesson7.adapter;

import java.time.LocalDateTime;

public interface MeteoSensor {

    int getId(); // идентификатор датчика

    double getTemperature(); // температура датчика

    double getHumidity(); // влажность

    double getPressure(); // давление

    LocalDateTime getDateTime(); // время чтения данных датчика
}
