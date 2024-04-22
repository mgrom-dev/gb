import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] lineInt = readLineInteger(scan);
        int n = lineInt[0];
        int k = lineInt[1];
        lineInt = readLineInteger(scan);
        scan.close();

        if (lineInt.length != n) return ;
        long startSumm = 0;
        for (int num : lineInt) startSumm += num;

        while(k-- > 0) {
            int[] maxIncreate = {0, 0, 0}; // index, icreased, value
            for (int i = 0; i < lineInt.length; i++) {
                int currentValue = lineInt[i];
                int maxCurrentValue = swap9Max(currentValue);
                int increased = maxCurrentValue - currentValue;
                if (increased > 0 && increased > maxIncreate[1]) {
                    maxIncreate[0] = i;
                    maxIncreate[1] = increased;
                    maxIncreate[2] = maxCurrentValue;
                }
            }
            if (maxIncreate[1] > 0)
                lineInt[maxIncreate[0]] = maxIncreate[2];
            else break;
        }
    
        long summ = 0;
        for (int num : lineInt) summ += num;
        System.out.println(summ - startSumm);
    }

    /**
     * Меняем одну цифру в числе на 9, чтобы получить максимальное число
     * @param number - число которое нужно максимизировать
     * @return
     */
    private static int swap9Max(int number) {
        int max = number;
        StringBuilder strValue = new StringBuilder(number + "");
        for (int i = 0, len = strValue.length(); i < len; i++) {
            if (strValue.charAt(i) != '9') {
                StringBuilder newValue = new StringBuilder(strValue);
                newValue.setCharAt(i, '9');
                int current = Integer.parseInt(newValue.toString());
                if (current > max) {
                    max = current;
                    break;
                }
            }
        }
        return max;
    }

    /**
     * Считываем строку целых чисел
     * @return возвращает массив целых чисел
     */
    private static int[] readLineInteger(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}