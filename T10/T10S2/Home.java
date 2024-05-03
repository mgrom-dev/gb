import java.util.Arrays;

public class Home {
    public static void main(String[] args) {
        System.out.println(countEvens(new int[] { 2, 1, 2, 3, 4 })); // 3
        System.out.println(countEvens(new int[] { 2, 2, 0 })); // 3
        System.out.println(countEvens(new int[] { 1, 3, 5 })); // 0
        System.out.println(diffMinMax(new int[] { 10, 2, 5, 8 })); // 8
        System.out.println(diffMinMax(new int[] { 1, 3, 5 })); // 4
        System.out.println(diffMinMax(new int[] { -2, 3, 12 })); // 14
        System.out.println(twoZero(new int[] { -2, 0, 1, 0, 3 })); // false
        System.out.println(twoZero(new int[] { 0, 1, 2, 0, 0, 3 })); // true
        System.out.println(twoZero(new int[] { 10, 0, 0 })); // true
    }

    /**
     * Написать метод, возвращающий количество чётных элементов массива.
     */
    public static int countEvens(int[] nums) {
        int count = 0;
        for (int i : nums)
            count += i & 1 ^ 1;
        return count;
    }

    /**
     * Написать функцию, возвращающую разницу между самым большим и самым
     * маленьким элементами переданного не пустого массива.
     */
    public static int diffMinMax(int[] nums) {
        return Arrays.stream(nums).max().getAsInt() -
                Arrays.stream(nums).min().getAsInt();
    }

    /**
     * Написать функцию, возвращающую истину, если в переданном массиве есть два
     * соседних элемента, с нулевым значением.
     */
    public static boolean twoZero(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == 0 && nums[i - 1] == 0) return true;
        return false;
    }
}
