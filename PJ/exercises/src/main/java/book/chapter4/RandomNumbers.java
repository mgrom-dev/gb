package book.chapter4;

import java.util.Random;

/**
 * Напишите программу, которая генерирует 25 случайных значений типа int. Для
 * каждого значения команда if-else сообщает, в каком отношении оно находится с
 * другим случайно сгенерированным числом (больше, меньше, равно).
 */
public class RandomNumbers {
    public static void main(String[] args) {
        Random rand = new Random();
        int prevNumber = rand.nextInt(10);
        for (int i = 0; i < 25; i++) {
            int number = rand.nextInt(10);
            if (number > prevNumber) System.out.printf("%d > %d\n", number, prevNumber);
            else if (number < prevNumber) System.out.printf("%d < %d\n", number, prevNumber);
            else System.out.printf("%d == %d\n", number, prevNumber);
            prevNumber = number;
        }
    }
}
