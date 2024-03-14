package ru.geekbrains.oop.lesson2.task1;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {



        Cat cat1 = new Cat("Армандо", "Белый");

        System.out.println(cat1.getColor());
        cat1.voice();
        Dog dog1 = new Dog("Шарик", 8);

        System.out.println(dog1.getWeight());
        dog1.jump();
        //Animal animal1 = new Animal("Животное");
        List<Animal> animals = new ArrayList<>();
        animals.add(cat1);
        animals.add(dog1);
        processVoice(animals);

    }
    static void processVoice(List<Animal> animals){
        for (Animal animal: animals) {

            if (animal instanceof Cat){
                Cat cat = (Cat)animal;
                System.out.println("Цвет котика: " + cat.getColor());
            }


            animal.voice();
            animal.jump();
        }
    }


}
