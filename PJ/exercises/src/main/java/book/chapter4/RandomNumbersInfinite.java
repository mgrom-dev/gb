package book.chapter4;

import java.util.Random;

/**
 * Измените упражнение 2 так, чтобы код выполнялся в «бесконечном» цикле while.
 * Программа должна работать до тех пор, пока ее выполнение не будет прервано с
 * клавиатуры (как правило, нажатием клавиш Ctrl+C).
 */
public class RandomNumbersInfinite {
    public static void main(String[] args) {
        Random rand = new Random();
        int prevNumber = rand.nextInt(10);
        while (true) {
            int number = rand.nextInt(10);
            if (number > prevNumber)
                System.out.printf("%d > %d\n", number, prevNumber);
            else if (number < prevNumber)
                System.out.printf("%d < %d\n", number, prevNumber);
            else
                System.out.printf("%d == %d\n", number, prevNumber);
            prevNumber = number;
        }
    }
}
