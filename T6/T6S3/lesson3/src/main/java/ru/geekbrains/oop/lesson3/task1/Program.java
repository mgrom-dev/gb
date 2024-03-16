package ru.geekbrains.oop.lesson3.task1;

public class Program {

    /**
     Задача 1
     ========
     Создать классы Собака и Кот с наследованием от класса Животное.
     Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
     Результатом выполнения действия будет печать в консоль. (Например, dog1.run(150); -> 'Бобик пробежал 150 м.');
     У каждого животного есть ограничения на действия
     (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
     Добавить подсчет созданных котов, собак и животных.
     */

    public static void main(String[] args) {

        try {



            Dog dog1 = Dog.create("~", 200, -300);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Animal[] animals = {
                new Cat("Армандо", 1000, 0),
                Dog.create("~", 200, -300),
                new Cat("Персик", 3000, 0),
                Dog.create("A", 200, -100),
                Dog.create("Бима", 400, 4000)
        };


        for (Animal a : animals){
            a.run(200);
            a.swim(10);
            a.run(1200);
            a.swim(210);
            a.run(3200);
            a.swim(210);
            a.run(2200);
            a.swim(150);
        }

        System.out.printf("Было создано %d животных\n", Animal.getCounter());
        System.out.printf("Было создано %d котов\n", Cat.getCounter());
        System.out.printf("Было создано %d собак\n", Dog.getCounter());
    }

}
