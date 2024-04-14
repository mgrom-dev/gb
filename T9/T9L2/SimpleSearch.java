public class SimpleSearch {
    public static void main(String[] args) {
        int[] array = {9, 5, 4, 8, 7, 3, 1, 2, 0, 6};
        int[] counter = {0};
        System.out.println("Позиция в массиве: " + simpleSearch(array, 2, counter));
        System.out.println("Количество итерации: " + counter[0]);
    }

    public static int simpleSearch(int[] array, int value, int[] counter) {
        for (int i = 0; i < array.length; i++, counter[0]++) {
           if (array[i] == value) return i;
        }
        return -1;
    }
}
