import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * Написать метод, осуществляющий сортировку одномерного
 * массива подсчётом. Важное ограничение состоит в том, что для этой
 * сортировки диапазон значений исходного массива должен находиться в
 * разумных пределах, например, не более 1000.
 */
public class Task5 {
    public static void main(String[] args) {
        int[] array = generateRandomArray(1000, 0, 1000);
        int[] arr = generateRandomArray(10, 0, 100);
        System.out.println(Arrays.toString(sort(array)));
        System.out.println(Arrays.toString(arr));
        pigeon(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }

    public static int[] sort(int[] array) {
        int[] tmpArr = new int[array.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        int i = 0;

        for (Entry<Integer, Integer> entry: map.entrySet()) {
            for (int r = 0; r < entry.getValue(); r++) {
                tmpArr[i++] = entry.getKey();
            }
        }

        return tmpArr;
    }

    public static void pigeon(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int n : array) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        int[] freq = new int[max - min + 1];
        for (int n : array) freq[n - min]++;
        int i = 0;
        for (int j = 0; j < freq.length; j++) {
            for (int k = 0; k < freq[j]; k++) {
                array[i++] = j + min;
            }
        }
    }
}
