import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        System.out.println("Исходный массив: " + Arrays.toString(nums));
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = val;
            i++;
        }
        System.out.println("Результирующий массив: " + Arrays.toString(nums));
    }
}
