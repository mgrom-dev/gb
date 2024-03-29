package T7S1;

import java.util.Scanner;

public class Task1 {
    public final static int MIN = 5;

    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 5, 6 };
        System.out.println(getArr(array) > 4);

        try (Scanner scanner = new Scanner(System.in)) {
            int searchNum = scanner.nextInt();
            int index = getIndex(array, searchNum);
            switch (index) {
                case -1:
                    System.out.println("Длина массива меньше заданного минимума");
                    break;
                case -2:
                    System.out.println("Искомый элемент не найден");
                    break;
                case -3:
                    System.out.println("Массив равен null");
                    break;
                case -4:
                    System.out.println("Искомое значение меньше нуля");
                    break;
                default:
                    System.out.println("Индекс элемента: " + index);
            }
        }

        int[][] matrix = { { 0, 1, 0 }, { 0, 1, 1 }, { 1, 0, 1 } };
        System.out.println("Сумма элементов матрицы: " + getSum(matrix));

        int sum = getSum2(matrix);
        switch (sum) {
            case -1:
                System.out.println("Матрица равна null");
                break;
            case -2:
                System.out.println("Матрица пуста");
            case -3:
                System.out.println("Матрица не квадратная");
            case -4:
                System.out.println("Недопустимое значение элемента матрицы");
            default:
                System.out.println("Сумма элементов матрицы: " + sum);
                break;
        }
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив. Если
     * длина массива меньше некоторого заданного минимума, метод возвращает -1, в
     * качестве кода ошибки, иначе - длину массива.
     */
    static int getArr(int array[]) {
        if (array.length < MIN)
            return -1;
        return array.length;
    }

    /**
     * 📔 Реализуйте метод, принимающий в качестве аргумента целочисленный массив и
     * некоторое значение. Метод ищет в массиве заданное значение и возвращает его
     * индекс. При этом, например:
     * 
     * 1. если длина массива меньше некоторого заданного минимума, метод возвращает
     * -1, в качестве кода ошибки.
     * 2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
     * 3. если вместо массива пришел null, метод вернет -3
     * 4. придумайте свои варианты исключительных ситуаций и верните соответствующие
     * коды ошибок.
     * 
     * Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть,
     * этот метод запросит искомое число у пользователя, вызовет первый, обработает
     * возвращенное значение и покажет читаемый результат пользователю. Например,
     * если вернулся -2, пользователю выведется сообщение: “Искомый элемент не
     * найден”.
     */
    static int getIndex(int array[], int value) {
        int result = -1;
        if (array == null)
            return -3;
        if (value < 0)
            return -4;
        if (getArr(array) != -1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value) {
                    result = i;
                    break;
                }
            }
            if (result < 0)
                result = -2;
        }
        return result;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный
     * массив. Необходимо посчитать и вернуть сумму элементов этого массива. При
     * этом накладываем на метод 2 ограничения: метод может работать только с
     * квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке
     * может лежать только значение 0 или 1. Если нарушается одно из условий, метод
     * должен бросить RuntimeException с сообщением об ошибке.
     */
    static int getSum(int[][] array) {
        int sum = 0;
        if (array == null)
            throw new RuntimeException("Массив равен null");
        if (array.length == 0)
            throw new RuntimeException("Массив пуст");
        if (array[0].length != array.length)
            throw new RuntimeException("Массив не квадратный");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1)
                    throw new RuntimeException("Ячейка массива может быть только 0 или 1");
                sum += array[i][j];
            }
        }
        return sum;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный
     * массив. Необходимо посчитать и вернуть сумму элементов этого массива. При
     * этом накладываем на метод 2 ограничения: метод может работать только с
     * квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке
     * может лежать только значение 0 или 1. Если нарушается одно из условий, метод
     * должен вернуть код ошибки. Программа должна корректно обработать код ошибки и
     * вывести соответствующее сообщение пользователю. Сравнить такой вариант
     * обработки исключений с предыдущим. Какое преимущество у исключений перед
     * кодами ошибок вы можете назвать в данном случае?
     */
    static int getSum2(int[][] array) {
        int sum = 0;
        if (array == null)
            return -1;
        if (array.length == 0)
            return -2;
        if (array[0].length != array.length)
            return -3;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1)
                    return -4;
                sum += array[i][j];
            }
        }
        return sum;
    }
}
