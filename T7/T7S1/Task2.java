package T7S1;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, null, 4, 5, 6 };
        Integer[] arr2 = { 1, 2, null, 4, 5, 6 };
        checkArray(arr);
        Integer[] arr3 = getSum(arr, arr2);
        System.out.println(Arrays.toString(arr3));
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 5}, { 6, 7, 8 } };
        if (checkMatrix(matrix)) System.out.println("матрица квадратная");
        else System.out.println("матрица не квадратная");
    }

    /**
     * Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента
     * целочисленный одномерный массив. Метод должен пройтись по каждому элементу и
     * проверить что он не равен null. А теперь реализуйте следующую логику:
     * 
     * 1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом
     * пользователя
     * 2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их
     * “подсветить”
     */
    static void checkArray(Integer[] arr) {
        if (arr == null)
            throw new RuntimeException("Массив равен null");
        if (arr.length == 0)
            throw new RuntimeException("Массив пуст");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                System.out.println("В ячейке " + i + " встретился null");
            }
        }
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных
     * массива, и возвращающий новый массив, каждый элемент которого равен сумме
     * элементов двух входящих массивов в той же ячейке. Если длины массивов не
     * равны, необходимо как-то оповестить пользователя.
     */
    static Integer[] getSum(Integer[] arr1, Integer[] arr2) {
        if (arr1.length != arr2.length)
            throw new RuntimeException(
                    "Длины массивов не равны arr1.length = " + arr1.length + " arr2.length = " + arr2.length);
        Integer[] result = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == null || arr2[i] == null) {
                System.out.println("В ячейке " + i + " встретился null");
            } else {
                result[i] = arr1[i] + arr2[i];
            }
        }
        return result;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента двумерный массив. Метод
     * должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
     * детализировать какие строки со столбцами не требуется. Как бы вы реализовали
     * подобный метод.
     */
    static boolean checkMatrix(int[][] matrix) {
        if (matrix == null)
            throw new RuntimeException("Массив равен null");
        if (matrix.length == 0)
            throw new RuntimeException("Массив пуст");
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                System.out.println("Длина строки массива не равна длине столбца");
                return false;
            }
        }
        return true;
    }
}
