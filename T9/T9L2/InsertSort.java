import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {9, 5, 4, 8, 7, 3, 1, 2, 0, 6};
        int[] counter = {0};
        insertSort(array, counter);
        System.out.println(Arrays.toString(array));
        System.out.println("Количество итерации: " + counter[0]);
    }

    public static void insertSort(int[] array, int[] counter) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++, counter[0]++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
