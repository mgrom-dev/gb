import java.util.ArrayList;
import java.util.Arrays;

/**
 * ���������� �����, ������� ��������� �� ���� ������������� ������ arr:
 * - ������ ������ ArrayList, ����������� ������� �� �������� ������� arr.
 * - ��������� ������ �� ����������� � ������� �� �����.
 * - ������� ����������� �������� � ������ � ������� �� ����� - Minimum is
 * {�����} - ������� ������������ �������� � ������ � ������� �� ����� - Maximum
 * is {�����}
 * - ������� ������� �������������� �������� ������ � ������� �� ����� - Average
 * is = {�����}
 * �������� ���� ��� � ������ analyzeNumbers ������ Answer. ����� analyzeNumbers
 * ��������� �� ���� ���� ��������:
 * 
 * Integer[] arr - ������ ����� �����.
 */
public class MinMaxAver {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // ��� �������� ���� �� ����������, �� ������ ����������� ��� ���������
            arr = new Integer[] { 4, 2, 7, 5, 1, 3, 8, 6, 9 };
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        analyzeNumbers(arr);
    }

    public static void analyzeNumbers(Integer[] arr) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(arr));
        numbers.sort((a, b) -> a - b);
        int min = numbers.get(0);
        int max = numbers.get(numbers.size() - 1);
        float aver = numbers.stream().reduce(0, (a, b) -> a + b) / (float)numbers.size();
        System.out.println(numbers);
        System.out.printf("Minimum is %d\n", min);
        System.out.printf("Maximum is %d\n", max);
        System.out.printf("Average is %.1f\n", aver);
    }
}
