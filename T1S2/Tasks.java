import java.util.Arrays;

public class Tasks {
    public static void main(String[] args) {
        Integer[] vector1 = {1, 2, 3, 4};
        Integer[] vector2 = {5, 6, 7, 8};
        System.out.println(String.format("Задача 1А. Скалярное произведение вектора %s и вектора %s, равно: %d", 
            arrayToString(vector1), arrayToString(vector2), scalarProduct(vector1, vector2)));
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
}