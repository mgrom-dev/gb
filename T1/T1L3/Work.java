public class Work {
    public static void main(String[] args) {
        int[] array = new int[10];
        int maxNumberInOrder = 4;
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
        int size = array.length;
        if (size < maxNumberInOrder) {
            return -1;
        }
        int[] maxNumbers = new int[maxNumberInOrder];
        for (int i = 0; i < size; i++) {
            int temp = -1;
            for (int y = maxNumberInOrder - 1; y >= 0; y--) {
                if (temp != -1) {
                    int temp2 = maxNumbers[y];
                    maxNumbers[y] = temp;
                    temp = temp2;
                }
                if (maxNumbers[y] < array[i] && temp == -1) {
                    temp = maxNumbers[y];
                    maxNumbers[y] = array[i];
                }
            }
        }
        return maxNumbers[0];
    }

    public static int findMaxValueInIntArray(int[] array) {
        return findMaxValueInIntArray(array, 1);
    }
}