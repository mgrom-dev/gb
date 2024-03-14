package ru.geekbrains.oop.lesson2.home;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного
 * количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
 * 2. Каждому коту нужно добавить поле сытость (когда создаем котов, они
 * голодны).
 * Если коту удалось покушать (хватило еды), сытость = true. Считаем, что если
 * коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
 * наполовину сыт (это сделано для упрощения логики программы).
 * 3. Создать массив котов и тарелку с едой, попросить всех котов покушать из
 * этой тарелки и потом вывести информацию о сытости котов в консоль.
 * 4. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в
 * тарелку.
 */

public class MainClass {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5);
        Cat cat2 = new Cat("Simba", 7);
        Cat cat3 = new Cat("Felix", 10);
        Cat cat4 = new Cat("Bella", 3);
        Cat cat5 = new Cat("Gizmo", 8);

        // Массив котов
        ArrayList<Cat> cats = new ArrayList<>(List.of(cat, cat2, cat3, cat4, cat5));

        // Создаем тарелку с едой
        Plate plate = new Plate(30);
        plate.info();

        // кормим котиков
        feedTheCats(cats, plate);
        plate.addFood(10);
        feedTheCats(cats, plate);
        plate.info();
    }

    // метод для кормления котиков
    public static void feedTheCats(ArrayList<Cat> cats, Plate plate) {
        for (Cat cat : cats) {
            if (!cat.isSatiety()) {
                if (plate.getFood() >= cat.getAppetite()) {
                    plate.setFood(plate.getFood() - cat.getAppetite());
                    cat.eat();
                    System.out.printf("Котик: %s, покушал на %d еды и теперь сытый и довольный. :)\n", cat.getName(), cat.getAppetite());
                } else {
                    System.out.printf("Котик: %s, хотел поесть на %d еды, но не смог. :( В тарелке всего лишь %d еды\n",
                    cat.getName(), cat.getAppetite(), plate.getFood());
                }
            }
        }
    }
}