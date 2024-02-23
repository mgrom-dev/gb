import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Написать метод, который переведёт данное целое число в римский формат.
 */
public class ToRoman {
    public static void main(String[] args) {
        System.out.println(toRoman(2022));
        System.out.println(toRoman(2024));
        System.out.println(toRoman(9));
    }

    public static Map<Integer, String> getRoman() {
        LinkedHashMap<Integer, String> nums = new LinkedHashMap<>();
        nums.put(1000, "M");
        nums.put(900, "CM");
        nums.put(500, "D");
        nums.put(400, "CD");
        nums.put(100, "C");
        nums.put(90, "XC");
        nums.put(50, "L");
        nums.put(40, "XL");
        nums.put(10, "X");
        nums.put(9, "IX");
        nums.put(5, "V");
        nums.put(4, "IV");
        nums.put(1, "I");
        return nums;
    }

    public static String toRoman(Integer num) {
        StringBuilder result = new StringBuilder();
        if (num < 1 || num > 3999)
            return "Error";
        var map = getRoman();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int value = entry.getKey();
            String roman = entry.getValue();

            while (num >= value) {
                result.append(roman);
                num -= value;
            }
        }
        return result.toString();
    }
}
