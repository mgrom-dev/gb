/**
 * Задать одномерный массив. Написать методы поиска в нём
 * минимального и максимального элемента;
 * 
 * Привести функции к корректному виду и дополнительно написать ещё две функции
 * так, чтобы получились (четыре) функции поиска минимального и максимального
 * как значения, так и индекса.
 */
public class Task1 {
    private static class MinMax {
        public int min;
        public int max;
        public int minIndex;
        public int maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 2, 8, 4 };
        MinMax minMax = fMinMax(arr);
        System.out.printf("min: %d, max: %d\n", minMax.min, minMax.max);
        System.out.printf("min index: %d, max index: %d\n", minMax.minIndex, minMax.maxIndex);
    }

    public static MinMax fMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        MinMax minMax = new MinMax();
        minMax.min = arr[0];
        minMax.max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minMax.min) {
                minMax.min = arr[i];
                minMax.minIndex = i;
            }
            if (arr[i] > minMax.max) {
                minMax.max = arr[i];
                minMax.maxIndex = i;
            }
        }
        return minMax;
    }
}
