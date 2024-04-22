import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long[] lineInt = readLineInteger(scan);
        long min = lineInt[0];
        long max = lineInt[1];
        scan.close();

        int count = 0;
        long num = 0;
        for (int x = 0, m = 0, k = 1; num <= max; x++, k++) {
            num = 10 * x + k;
            if (num >= min && num <= max) count++;
            if (k == 9) {
                k = 0;
                m = m == 0 ? 10 : m * 10;
            }
        }
        
        System.out.println(count);
    }

    /**
     * Считываем строку целых чисел
     * @return возвращает массив целых чисел
     */
    private static long[] readLineInteger(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }
}