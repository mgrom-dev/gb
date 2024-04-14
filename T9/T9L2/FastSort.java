import java.util.Arrays;

public class FastSort {
    public static void main(String[] args) {
        int[] array = {9, 5, 4, 8, 7, 3, 1, 2, 0, 6};
        int[] counter = {0};
        fastSort(array, counter);
        System.out.println(Arrays.toString(array));
        System.out.println("Количество итерации: " + counter[0]);
    }

    public static void fastSort(int[] array, int[] counter) {
        fastSort(array, counter, 0, array.length - 1);
    }

    public static void fastSort(int[] array, int[] counter, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            counter[0]++;
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int tmp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = tmp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);

        if (startPosition < rightPosition) {
            fastSort(array, counter, startPosition, rightPosition);
        }
        if (leftPosition < endPosition) {
            fastSort(array, counter, leftPosition, endPosition);
        }
    }
}