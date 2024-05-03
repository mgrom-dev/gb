import java.util.Arrays;

/**
 * Написать метод, принимающий на вход массив чисел и параметр n. Метод должен
 * осуществить циклический (последний элемент при сдвиге становится первым)
 * сдвиг всех элементов массива на n позиций;
 */
public class Shifter {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        shifter(arr, 2);
        System.out.println(Arrays.toString(arr));
        shifter(arr, -2);
        System.out.println(Arrays.toString(arr));
    }

    public static void shifter(int[] a, int n) {
        n %= a.length;
        int shift = a.length + n;
        shift %= a.length;

        for (int i = 0; i < shift; i++) {
            int temp = a[a.length - 1];
            System.arraycopy(a, 0, a, 1, a.length - 1);
            a[0] = temp;
        }
    }
}
