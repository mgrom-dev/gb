package ru.geekbrains.oop.lesson7.adapter;

import java.time.LocalDateTime;

public class AdapterST500 implements MeteoSensor{

    private SensorTemperature sensorTemperature;

    public AdapterST500(SensorTemperature sensorTemperature) {
        this.sensorTemperature = sensorTemperature;
    }

    @Override
    public int getId() {
        return sensorTemperature.getIdentifier();
    }

    @Override
    public double getTemperature() {
        return sensorTemperature.temperature();
    }

    @Override
    public double getHumidity() {
        return 0;
    }

    @Override
    public double getPressure() {
        return 0;
    }

    @Override
    public LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }
}
