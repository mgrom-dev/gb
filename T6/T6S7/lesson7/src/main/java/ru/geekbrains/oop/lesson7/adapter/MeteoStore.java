package ru.geekbrains.oop.lesson7.adapter;

import java.time.LocalDateTime;

public class MeteoStore {

    boolean save(MeteoSensor meteoSensor){
        System.out.format("Saving data from sensor [%d] at %s%n temperature - %.2f ; humidity - %.2f ; pressure - %.2f \n\r",
                meteoSensor.getId(),
                meteoSensor.getDateTime(),
                meteoSensor.getTemperature(),
                meteoSensor.getHumidity(),
                meteoSensor.getPressure());
        return true;
    }

}
