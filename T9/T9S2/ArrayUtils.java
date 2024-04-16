import java.util.Random;

public class ArrayUtils {
    private static Random random = new Random();

    /**
     * Подготовить массив случайных чисел
     * @return
     */
    public static int[] prepareArray() {
        return prepareArray(10 + random.nextInt(6));
    }

    /**
     * Подготовить массив случайных чисел
     * @return
     */
    public static int[] prepareArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = -99 + random.nextInt(200);
        }
        return array;
    }

    /**
     * Распечатать массив в консоли
     * @param array
     */
    public static void printArray(int[] array) {
        for (int e : array) {
            System.out.printf("%d\t", e);
        }
        System.out.println();
    }
}