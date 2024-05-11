package ru.home;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Barsik"));
        animals.add(new Bird("parrot"));
        animals.add(new Dog("Rex"));

        for (Animal animal : animals) {
            StringBuilder sb = new StringBuilder();
            if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                sb.append("id: " + cat.getId() + ". ");
            }
            sb.append(animal.getType() + ": " + animal.getName() + "\n");
            if (animal.jump(23f)) sb.append("\tjumped over barrier 23f.\n");
            else sb.append("\tcouldn't jump over barrier 23f.\n");
            if (animal.swim(65f)) sb.append("\tswimmed over barrier 65f.\n");
            else sb.append("\tcouldn't swimm over barrier 65f.\n");
            if (animal.run(120f)) sb.append("\trunned 120f.\n");
            else sb.append("\tdon't runned 120f.\n");
            System.out.println(sb.toString());
        }
    }
}