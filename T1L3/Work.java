public class Work {
    public static void main(String[] args) {
        int[] array = new int[10];
        int maxNumberInOrder = 2;
        String message = "В массиве: ";
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        message += intArrayToString(array) + ", " + maxNumberInOrder + " максимальное по счету число равняется ";
        int maxNumber = findMaxValueInIntArray(array, maxNumberInOrder);
        System.out.println(message + maxNumber);
    }

    public static String intArrayToString(int[] array) {
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                result += ", ";
            }
            result += array[i];
        }
        return result + "]";
    }

    public static int findMaxValueInIntArray(int[] array, int maxNumberInOrder) {
        int maxNumber = 0;
        int size = array.length;
        for (int repeat = 0; repeat < maxNumberInOrder; repeat++) {
            int maxNumberIndex = 0;
            for (int i = 0; i < size; i++) {
                if (array[i] > array[maxNumberIndex]) {
                    maxNumberIndex = i;
                }
            }
            maxNumber = array[maxNumberIndex];
            array[maxNumberIndex] = 0;
        }
        return maxNumber;
    }

    public static int findMaxValueInIntArray(int[] array) {
        return findMaxValueInIntArray(array, 1);
    }
}