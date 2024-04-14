public class Task3 {
    public static void main(String[] args) {
        int[] testNum = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        test(testNum);
    }

    public static void test(int[] numbers) {
        for (int i : numbers) {
            long[] c = { 0 };
            System.out.printf("Последовательность Фибоначи от %d: %,d\n",
                    i, fb2(i, c));
            System.out.println("Кол-во итерации: " + c[0]);
        }
    }

    /**
     * 1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
     * 2. Считаем, что 1 и 2 значения последовательности равны 1.
     * 3. Искать будем по формуле On = On-1 + On-2 что предполагает использовать
     * рекурсивного алгоритма. Экспоненциальная сложность
     * Числа Фибоначчи это последовательность, в которой каждое следующее число
     * равно сумме двух предыдущих чисел
     * 0 1 1 2 3 5 8 13 21 34 55 ...
     */
    public static long fb1(long num, long c[]) {
        c[0]++;
        if (num <= 1) return num;
        return fb1(num - 1, c) + fb1(num - 2, c);
    }

    /**
     * с использованием массива. Линейная сложность
     */
    public static long fb2(long num, long c[]) {
        if (num <= 1) return num;
        long[] array = new long[(int)num + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= num; i++, c[0]++)
            array[i] = array[i - 1] + array[i - 2];
        return array[(int)num];
    }
}
