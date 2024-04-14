import java.util.Arrays;

public class ChangeSort {
    public static void main(String[] args) {
        int[] array = {9, 5, 4, 8, 7, 3, 1, 2, 0, 6};
        int[] counter = {0};
        changeSort(array, counter);
        System.out.println(Arrays.toString(array));
        System.out.println("Количество итерации: " + counter[0]);
    }

    public static void changeSort(int[] array, int[] counter) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++, counter[0]++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int tmp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = tmp;
            }
        }
    }
}
