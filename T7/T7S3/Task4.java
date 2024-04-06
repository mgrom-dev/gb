/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив
 * размером 4х4. При подаче массива другого размера необходимо бросить
 * исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в
 * int и просуммировать. Если в каком-то элементе массива преобразование
 * не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException с детализацией, в
 * какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные
 * исключения MyArraySizeException и MyArrayDataException и вывести
 * результат расчета (сумму элементов, при условии что подали на вход
 * корректный массив).
 */

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("\nРазмер массива должен быть 4х4!");
    }
}

class MyArrayDataException extends Exception {
    int i;
    int j;
    String message;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;

    }

    @Override
    public String toString() {
        return "Ошибка в ячейке [" + i + "][" + j + "]";
    }
}

public class Task4 {
    public static void main(String[] args) {
        String arr[][] = {
                { "1", "2", "3", "6" },
                { "5", "6", "7", "4" },
                { "9", "5", "11", "12" },
                { "13", "31", "15", "16" }
        };

        try {
            System.out.println(getSumm(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int getSumm(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int i = 0, j = 0;
        try {
            if (arr.length != 4)
                throw new MyArraySizeException();
            for (i = 0; i < arr.length; i++) {
                if (arr[i].length != 4)
                    throw new MyArraySizeException();
                for (j = 0; j < arr[i].length; j++) {
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        } catch (MyArraySizeException ex) {
            throw new MyArraySizeException();
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException(i, j);
        }

        return sum;
    }

}
