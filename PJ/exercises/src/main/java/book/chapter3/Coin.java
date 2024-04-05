package book.chapter3;

import java.util.Random;

/**
 * Напишите программу, моделирующую бросок монетки.
 */
public class Coin {
    public static void main(String[] args) {
        throwCoin();
        throwCoin();
        throwCoin();
        throwCoin();
        throwCoin();
    }

    static int throwCoin() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            System.out.println("Орел");
            return 1;
        } else {
            System.out.println("Решка");
            return 0;
        }
    }
}
