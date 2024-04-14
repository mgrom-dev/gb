public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] counter = {0};
        System.out.println("Позиция в массиве: " + binarySearch(array, 9, counter));
        System.out.println("Количество итерации: " + counter[0]);
    }

    public static int binarySearch(int[] array, int value, int[] counter) {
        return binarySearch(array, value, 0, array.length - 1, counter);
    }

    public static int binarySearch(int[] array, int value, int min, int max, int[] counter) {
        int midPoint;
        counter[0]++;
        if (max < min) return -1;
        else midPoint = (max - min) / 2 + min;
        if (array[midPoint] < value)
            return binarySearch(array, value, midPoint + 1, max, counter);
        else if (array[midPoint] > value)
            return binarySearch(array, value, min, midPoint - 1, counter);
        else return midPoint;
    }
}
