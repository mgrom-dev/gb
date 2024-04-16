namespace ArraySortTests {
    public class SortUtils {
        public static void directSort(int[] array) {
            for (int i = 0; i < array.Length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < array.Length; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    int temp = array[i];
                    array[i] = array[minIndex];
                    array[minIndex] = temp;
                }
            }
        }

        public static void quickSort(int[] array) {
            if (array == null || array.Length <= 1) {
                return;
            }
            quickSort(array, 0, array.Length - 1);
        }

        private static void quickSort(int[] array, int start, int end) {
            int left = start;
            int right = end;

            int middle = array[(start + end) / 2];

            do {
                while (array[left] < middle) {
                    left++;
                }

                while (array[right] > middle) {
                    right--;
                }

                if (left <= right) {
                    if (left < right) {
                        int buf = array[left];
                        array[left] = array[right];
                        array[right] = buf;
                    }
                    left++;
                    right--;
                }
            } while (left <= right);

            if (left < end) {
                quickSort(array, left, end);
            }
            if (start < right) {
                quickSort(array, start, right);
            }
        }
    }
}