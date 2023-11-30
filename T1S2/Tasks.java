import java.util.Arrays;
import java.util.Random;

public class Tasks {
    /** класс под минимальное и максимальное целое значение */
    public static class MinMaxIndex {
        int min;
        int max;

        public MinMaxIndex(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Integer[] vector1 = {1, 2, 3, 4};
        Integer[] vector2 = {5, 6, 7, 8};
        System.out.println(String.format("Задача 1А. Скалярное произведение вектора %s и вектора %s, равно: %d", 
            arrayToString(vector1), arrayToString(vector2), scalarProduct(vector1, vector2)));
        
        Integer[] minMaxArray = Arrays.stream( new Random().ints(10, 0, 100).toArray() ).boxed().toArray( Integer[]::new );
        MinMaxIndex minMaxIndex = findMinAndMaxValue(minMaxArray);
        System.out.println(String.format("Домашнее задание 1. Задан массив %s размером %d элементов\nИндекс минимального значения в массиве %d\nИндекс максимального значения в массиве %d", 
           arrayToString(minMaxArray), minMaxArray.length, minMaxIndex.min, minMaxIndex.max));

        System.out.println(String.format("Домашнее задание 2. Задан массив %s размером %d элементов\nМассив в обратном порядке %s", 
           arrayToString(minMaxArray), minMaxArray.length, arrayToString(revert(minMaxArray))));

        System.out.println(String.format("Домашнее задание 3. Задан массив %s размером %d элементов\nСумма элементов массива, лежащих между максимальным и минимальным по значению элементами, равна: %d", 
           arrayToString(minMaxArray), minMaxArray.length, summAboveMinAndMaxArray(minMaxArray)));

        System.out.println(String.format("Домашнее задание 4. Задан массив %s размером %d элементов\nCреднее арифметическое среди всех элементов массива: %.1f", 
           arrayToString(minMaxArray), minMaxArray.length, average(minMaxArray)));
    }

    /**
     * Преобразование массива целых чисел в строку
     * @param array - массив целых чисел
     * @return - строка вида "1,2,3"
     */
    public static String arrayToString(Integer[] array) {
        return "[" + Arrays.stream(array)
                .map(String::valueOf)
                .reduce((x, y) -> x + ", " + y)
                .get() + "]";
    }

    /**
     * Нахождение скалярного произведения 2ух векторов произвольной размерности
     * @param vector1 - 1 вектор массив целых чисел
     * @param vector2 - 2 вектор массив целых чисел
     * @return - произведение векторов, целое число
     */
    public static Integer scalarProduct(Integer[] vector1, Integer[] vector2) {
        Integer scalarProduct = 0;
        if (vector1.length != vector2.length) {
            String message = String.format("\nОшибка! Векторы должны быть одинаковым размером \nВектор %s - размер %d\nВектор %s - размер %d", 
            arrayToString(vector1), vector1.length, arrayToString(vector2), vector2.length);
            throw new IndexOutOfBoundsException(message);
        }
        for (int i = 0; i < vector1.length; i++) {
            scalarProduct += vector1[i] * vector2[i];
        }
        return scalarProduct;
    }

    /**
     * Поиск индексов миинимального и максимального значения 
     * @param array - массив целых чисел
     * @return возвращает объект со свойствами min и max
     */
    public static MinMaxIndex findMinAndMaxValue(Integer[] array) {
        MinMaxIndex indexes = new MinMaxIndex(0, 0);
        for (int i = 1; i < array.length; i++) {
            if (array[indexes.min] > array[i]) {
                indexes.min = i;
            }
            if (array[indexes.max] < array[i]) {
                indexes.max = i;
            }
        }
        return indexes;
    }

    /**
     * Разворот массива наоборот
     * @param array - массив целых чисел
     * @return - массив в обратном порядке
     */
    public static Integer[] revert(Integer[] array) {
        Integer tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }

    /**
     * Cумма элементов массива, лежащих между максимальным и минимальным по значению элементами
     * @param array - массив целых чисел
     * @return - сумма
     */
    public static int summAboveMinAndMaxArray(Integer[] array) {
        int summ = 0;
        MinMaxIndex indexes = new MinMaxIndex(0, 0);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[indexes.max]) {
                indexes.max = i;
            }
            if (array[i] < array[indexes.min]) {
                indexes.min = i;
            }
        }
        if (indexes.min > indexes.max) {
            int temp = indexes.min;
            indexes.min = indexes.max;
            indexes.max = temp;
        }
        for (int i = indexes.min + 1; i < indexes.max; i++) {
            summ += array[i];
        }
        return summ;
    }

    /**
     * Среднее арифметическое среди всех элементов массива
     * @param array - массив целых чисел
     * @return - среднее значение
     */
    public static double average(Integer[] array) {
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            summ += array[i];
        }
        return (double) summ / array.length;
    }
}