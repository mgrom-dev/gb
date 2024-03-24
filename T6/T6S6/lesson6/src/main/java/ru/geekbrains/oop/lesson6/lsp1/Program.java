package ru.geekbrains.oop.lesson6.lsp1;

import java.util.ArrayList;
import java.util.List;

public class Program {

    // Тип S будет подтипом Т тогда и только тогда,
    // когда каждому объекту oS типа S соответствует некий объект oT типа T таким образом,
    // что для всех программ P,
    // реализованных в терминах T, поведение P не будет меняться, если oT заменить на oS.

    public static void main(String[] args) {

        Bird bird1 = new Bird(); // oT
        Bird bird2 = new Bird(); // oT
        Bird bird3 = new Bird(); // oT
        Bird bird4 = new Bird(); // oT
        Bird bird5 = new Bird(); // oT
        Duck duck1 = new Duck(); // oS
        Duck duck2 = new Duck(); // oS
        Penguin penguin1 = new Penguin();
        penguin1.fly();

        List<Bird> birds = new ArrayList<>();
        birds.add(bird1);
        birds.add(bird2);
        birds.add(bird3);
        birds.add(bird4);
        birds.add(bird5);
        birds.add(duck1);
        birds.add(duck2);
        birds.add(penguin1);

        processBirdFly(birds);
    }

    /**
     * P
     * @param birds
     */
    public static void processBirdFly(List<Bird> birds){
        for (Bird bird : birds){
            if (bird.isCanFly())
                bird.fly();
        }
    }

}
