public class Task1 {
    public static void main(String[] args) {
        long lastNumber = 1_000_000_000L;
        long[] c = {0};
        long startTime = System.currentTimeMillis();
        System.out.printf("(1) Сумма всех чисел от 1 до %,d равна %,d\n", lastNumber, sum(lastNumber, c));
        long endTime = System.currentTimeMillis();
        System.out.println("Кол-во итерации: " + c[0] + ", время: " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        System.out.printf("(2) Сумма всех чисел от 1 до %,d равна %,d\n", lastNumber, sumV2(lastNumber));
        endTime = System.currentTimeMillis();
        System.out.println("Константный алгоритм время: " + (endTime - startTime));
    }

    /**
     * Необходимо написать алгоритм, считающий сумму всех чисел
     * от 1 до N. Согласно свойствам линейной сложности,
     * количество итераций цикла будет линейно изменяться
     * относительно изменения размера N.
     */
    public static long sum(long lastNumber, long[] c){
        long sum = 0;
        for (long i = 1; i <= lastNumber; i++) {
            sum += i;
            c[0]++;
        }
        return sum;
    }

    /**
     * Константная сложность
     */
    public static long sumV2(long lastNumber){
        return ((long)(1 + lastNumber) * lastNumber) / 2;
    }
}