public class SearchUtils {
    public static int binarySearch(int[] array, int value) {
        if (array == null)
            return -1;
        return binarySearch(array, value, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int value, int min, int max) {
        if (max < min)
            return -1;
        int middle = (min + max) / 2;
        if (array[middle] == value)
            return middle;
        if (array[middle] < value)
            return binarySearch(array, value, middle + 1, max);
        return binarySearch(array, value, min, middle - 1);
    }
}
