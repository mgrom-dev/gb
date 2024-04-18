import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        System.out.println();
        int[] array = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array);
        SortUtils.directSort(array);
        ArrayUtils.printArray(array);

        array = new int[] {5, 4, 1, 0, 1};
        int[] testArray = array.clone();
        ArrayUtils.printArray(testArray);
        SortUtils.quickSort(testArray);
        ArrayUtils.printArray(testArray);

        array = ArrayUtils.prepareArray();
        SortUtils.heapsort(array);
        System.out.println("heap sort");
        ArrayUtils.printArray(array);
        // array = ArrayUtils.prepareArray(150_000);

        // long startTime = System.currentTimeMillis();
        // SortUtils.directSort(array.clone());
        // long endTime = System.currentTimeMillis();
        // System.out.printf("Время работы сортировки выбором %d мс.\n", endTime - startTime);

        // startTime = System.currentTimeMillis();
        // SortUtils.quickSort(array.clone());
        // endTime = System.currentTimeMillis();
        // System.out.printf("Время работы быстрой сортировки %d мс.\n", endTime - startTime);

        // startTime = System.currentTimeMillis();
        // Arrays.sort(array.clone());
        // endTime = System.currentTimeMillis();
        // System.out.printf("Время работы системной быстрой сортировки %d мс.\n", endTime - startTime);
        array = new int[] {-5, 10, 11, -6, -50, 40, 11, 3, 2, 17};
        ArrayUtils.printArray(array);
        SortUtils.quickSort(array);
        ArrayUtils.printArray(array);
        int searchElement = 3;
        int res = SearchUtils.binarySearch(array, searchElement);
        System.out.printf("Элемент %d %s", 
            searchElement, 
            res >= 0 ? String.format("найден в массиве под индексом %d", res) : "не найден в массиве");
    }
}
