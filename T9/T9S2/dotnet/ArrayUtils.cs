namespace ArraySortTests {
    public class ArrayUtils {
        private static Random random = new Random();

        /**
        * Подготовить массив случайных чисел
        * @return
        */
        public static int[] prepareArray() {
            return prepareArray(10 + random.Next(10, 16));
        }

        /**
        * Подготовить массив случайных чисел
        * @return
        */
        public static int[] prepareArray(int length) {
            int[] array = new int[length];
            for (int i = 0; i < array.Length; i++) {
                array[i] = -99 + random.Next(-99, 100);
            }
            return array;
        }

    }
}