import java.util.Arrays;

/**
 * Внутри класса MergeSort напишите метод mergeSort, который принимает массив
 * целых чисел, реализует алгоритм сортировки слиянием. Метод должен возвращать
 * отсортированный массив.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[] { 5, 1, 6, 2, 3, 4 };
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        String itresume_res = Arrays.toString(mergeSort(a));
        System.out.println(itresume_res);
    }

    public static int[] mergeSort(int[] a) {
        if (a == null || a.length <= 1) {
            return null;
        }
        int[] helper = new int[a.length];
        mergeSort(a, helper, 0, a.length - 1);
        return a;
    }

    public static void mergeSort(int[] arr, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, helper, low, middle);
            mergeSort(arr, helper, middle + 1, high);
            merge(arr, helper, low, middle, high);
        }
    }

    public static void merge(int[] arr, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else {
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = helper[helperLeft + i];
        }
    }
}
