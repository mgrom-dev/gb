import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        System.out.println();
        int[] array = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array);
        SortUtils.directSort(array);
        ArrayUtils.printArray(array);

        array = new int[] {5, 4, 1, 0, 1};
        ArrayUtils.printArray(array);
        SortUtils.quickSort(array);
        ArrayUtils.printArray(array);

        array = ArrayUtils.prepareArray(150_000);

        long startTime = System.currentTimeMillis();
        SortUtils.directSort(array.clone());
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы сортировки выбором %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортировки %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        Arrays.sort(array.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы системной быстрой сортировки %d мс.\n", endTime - startTime);
    }
}
