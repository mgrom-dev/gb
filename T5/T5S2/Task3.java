/**
 * Напишите метод, который принимает на вход строку (String) и определяет
 * является ли строка палиндромом (возвращает boolean значение).
 */
public class Task3 {
    public static void main(String[] args) {
        String str = " шалаш  ";
        System.out.println(isPalindrome(str)); // Output: true
    }

    public static boolean isPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-zа-я0-9]", "");
        for (int left = 0, right = str.length() - 1; left < right; left++, right--)
            if (str.charAt(left) != str.charAt(right))
                return false;
        return true;
    }
}
