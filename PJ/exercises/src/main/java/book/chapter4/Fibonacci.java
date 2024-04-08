package book.chapter4;

/**
 * Числами Фибоначчи называется числовая последовательность 1,1,2,3,5,8,13,21,34
 * и т. д., в которой каждое число, начиная с третьего, является суммой двух
 * предыдущих. Напишите метод, который получает целочисленный аргумент и выводит
 * указанное количество чисел Фибоначчи. Например, при запуске командой java
 * Fibonacci 5 (где Fibonacci — имя класса) должна выводиться последовательность
 * 1, 1, 2, 3, 5.
 */
public class Fibonacci {
    public static void main(String[] args) {
        int f = 0;
        if (args.length == 1) f = Integer.parseInt(args[0]);
        for (int i = 0, sum[] = {0, 0}; i < f; i++) {
            int tmp = sum[1];
            sum[1] = sum[0] + sum[1];
            sum[0] = tmp;
            if (i < 2) sum[1] = 1;
            if (i > 0) System.out.print(", ");
            System.out.print(sum[1]);
        }
        System.out.println("");
    }
}
