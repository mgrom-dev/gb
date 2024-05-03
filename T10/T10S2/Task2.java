/**
 * Создать квадратный целочисленный массив (количество строк и
 * столбцов одинаковое), заполнить его диагональные элементы единицами,
 * используя цикл(ы)
 */
public class Task2 {
    public static void main(String[] args) {
        int[][] array = createSquareArray(5);
        fillDiagonal(array);
        printArray(array);
    }

    public static int[][] createSquareArray(int n) {
        int[][] array = new int[n][n];
        return array;
    }

    public static void fillDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
