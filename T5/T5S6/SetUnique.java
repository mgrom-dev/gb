import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 1. Напишите метод, который заполнит массив из 1000 элементов случайными
 * цифрами от 0 до 500.
 * 2. Создайте метод, в который передайте заполненный выше массив и с
 * помощью Set вычислите процент уникальных значений в данном массиве и
 * верните его в виде числа с плавающей запятой.
 * Для вычисления процента используйте формулу:
 * процент уникальных чисел = количество уникальных чисел * 100 / общее
 * количество чисел в массиве.
 */
public class SetUnique {
    public static void main(String[] args) {
        int[] array = createRandomArray(1000, 500);
        System.out.println(countUniqueValueFromArray(array));
    }

    public static int[] createRandomArray(int size, int max) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int index = 0; index < size; index++) {
            array[index] = rand.nextInt(max + 1);
        }
        return array;
    }

    public static float countUniqueValueFromArray(int[] array){
        Set<Integer> unique = new HashSet<>();
        unique.addAll(Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new)));
        return (float) unique.size() * 100 / array.length;
    }
}