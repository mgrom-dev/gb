import java.util.Arrays;

public class BubbleSort{
    public static void main(String[] args) {
        int[] array = {9, 5, 4, 8, 7, 3, 1, 2, 0, 6};
        int[] counter = {0};
        bubbleSort(array, counter);
        System.out.println(Arrays.toString(array));
        System.out.println("Количество итерации: " + counter[0]);
    }

    public static void bubbleSort(int[] array, int[] counter) {
        boolean finish = true;
        do {
            finish = true;
            System.out.println(Arrays.toString(array));
            for (int i = 0; i < array.length - 1; i++, counter[0]++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    finish = false;
                }
            }
        } while (!finish);
    }
}