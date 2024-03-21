package ru.geekbrains.oop.lesson4.homework;
import java.util.Random;

public class Program {

    /**
     Домашняя работа, задача:
     ========================

     a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
     b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
     поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
     вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
     подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     Можно сравнивать коробки с яблоками и апельсинами;
     f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     g. Не забываем про метод добавления фрукта в коробку.
     */
    public static void main(String[] args) {
        Random random = new Random();

        // Создаем коробки для яблок
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        // Создаем коробки для апельсинов
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        // Генерируем случайное количество итераций от 50 до 100
        int count = random.nextInt(51) + 50;

        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                Apple apple = new Apple();
                if (random.nextBoolean()) {
                    appleBox1.addFruit(apple);
                } else {
                    appleBox2.addFruit(apple);
                }
            } else {
                Orange orange = new Orange();
                if (random.nextBoolean()) {
                    orangeBox1.addFruit(orange);
                } else {
                    orangeBox2.addFruit(orange);
                }
            }
        }

        // Выводим вес каждой коробки
        System.out.println("Вес 1 коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес 2 коробки с яблоками: " + appleBox2.getWeight());
        System.out.println("Вес 1 коробки с апельсинами: " + orangeBox1.getWeight());
        System.out.println("Вес 2 коробки с апельсинами: " + orangeBox2.getWeight());
        
        // Выводим результат сравнения веса коробок
        System.out.println("appleBox1.weight == orangeBox1.weight" + appleBox1.compare(orangeBox1));

        // пересыпаем коробки
        appleBox1.putsFruitsToAnotherBox(appleBox2);
        System.out.println("Вес 1 коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес 2 коробки с яблоками: " + appleBox2.getWeight());
    }

}
