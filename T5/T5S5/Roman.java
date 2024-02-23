import java.util.HashMap;
import java.util.Map;

/**
 * Написать метод, который переведет число из римского формата записи в
 * арабский.
 * Например, MMXXII = 2022
 * 'I', 1
 * 'V', 5
 * 'X', 10
 * 'L', 50
 * 'C', 100
 * 'D', 500
 * 'M', 1000
 */
public class Roman {
    public static void main(String[] args) {
        System.out.println(convertToArabic("MMXXII"));
        System.out.println(convertToArabic("MMXXIV"));
        System.out.println(convertToArabic("IX"));
    }

    public static Map<Character, Integer> getNumbers() {
        Map<Character, Integer> numbers = new HashMap<>();
        numbers.put('I', 1);
        numbers.put('V', 5);
        numbers.put('X', 10);
        numbers.put('L', 50);
        numbers.put('C', 100);
        numbers.put('D', 500);
        numbers.put('M', 1000);
        return numbers;
    }

    public static Integer convertToArabic(String number) {
        var map = getNumbers();
        int result = 0;
        int prevNum = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int num = map.get(number.charAt(i));

            if (num < prevNum)
                result -= num;
            else
                result += num;

            prevNum = num;
        }
        return result;

    }
}