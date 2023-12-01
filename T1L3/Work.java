public class Work {
    public static void main(String[] args) {
        int[] array = new int[10];
        int size = array.length;
        int nLargest = 2;
        int maxNumber = 0;
        String message = "В массиве: ";
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        message += intArrayToString(array) + ", " + nLargest + " максимальное по счету число равняется ";
        for (int repeat = 0; repeat < nLargest; repeat++) {
            int maxNumberIndex = 0;
            for (int i = 0; i < size; i++) {
                if (array[i] > array[maxNumberIndex]) {
                    maxNumberIndex = i;
                }
            }
            maxNumber = array[maxNumberIndex];
            array[maxNumberIndex] = 0;
        }
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
}