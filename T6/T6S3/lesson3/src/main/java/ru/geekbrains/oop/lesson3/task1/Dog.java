package ru.geekbrains.oop.lesson3.task1;

public class Dog extends Animal{

    private static int counter;

    {
        counter++;
    }

    public static int getCounter(){
        return counter;
    }


    private Dog(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
    }

    public static Dog create(String name, int maxRun, int maxSwim){
        if (name == null || name.length() < 3){
            throw new RuntimeException("Имя животного указано некорректно.");
        }
        if (maxRun < 0 || maxSwim < 0){
            throw new RuntimeException("Параметры животного должны быть указаны корректно.");

        }
        return new Dog(name, maxRun, maxSwim);
    }


}
