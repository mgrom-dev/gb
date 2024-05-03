/**
 * Написать метод, в который передается не пустой одномерный целочисленный
 * массив, метод должен вернуть true если в массиве есть место, в котором сумма
 * левой и правой части массива равны.
 * Примеры:
 * checkBalance([1, 1, 1, || 2, 1]) → true,
 * checkBalance([2, 1, 1, 2, 1]) → false,
 * checkBalance([10, || 1, 2, 3, 4]) → true.
 * Абстрактная граница показана символами ||, эти символы в массив не входят.
 * 
 * написать этот же метод таким образом, чтобы в нём использовался только один
 * цикл
 */
public class Task3 {
    public static void main(String[] args) {
        System.out.println(checkBalance2(new int[] { 1, 1, 1, 2, 1 }));
        System.out.println(checkBalance2(new int[] { 2, 1, 1, 2, 1 }));
        System.out.println(checkBalance2(new int[] { 10, 1, 2, 3, 4 }));
    }

    public static boolean checkBalance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            sum -= nums[i];
            if (leftSum == sum)
                return true;
        }
        return false;
    }

    public static boolean checkBalance2(int[] nums) {
        int lbound = 0;
        int rbound = nums.length - 1;
        int left = 0;
        int right = 0;
        while (lbound <= rbound) {
            if (left > right)
                right += nums[rbound--];
            else
                left += nums[lbound++];
        }
        return left == right;
    }

    public static boolean checkBalance3(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            int right = 0;
            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }
            if (left == right)
                return true;
        }
        return false;
    }
}
