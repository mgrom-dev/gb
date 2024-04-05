package book.chapter3;

import java.util.Random;

/**
 * Напишите программу, которая вычисляет скорость для постоянных значений расстояния и времени.
 */
public class Speed {
    public static void main(String[] args) {
        Random rand = new Random();
        int distance = 1 + rand.nextInt(1000);
        int time = 1 + rand.nextInt(200);
        System.out.printf("Distance=%dkm, Time=%dmin\n(S) D / T * 60 = %.1fkm/h\n", distance, time, calcSpeed(distance, time));
    }

    /**
     * Метод вычисляет скорость исходя из пройденного расстояния и затраченного времени
     * @param distance - расстояние в км
     * @param time - время в минутах
     * @return - возвращает скорость в км/ч
     */
    static float calcSpeed(int distance, int time) {
        return (float) distance / time * 60;
    }
}
