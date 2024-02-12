/**
 * Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd.
 */
public class Task2 {
    public static void main(String[] args) {
        String input = "aaaabbbcdd";
        System.out.println(packString(input)); // Output: "a4b3c1d2"
    }

    public static String packString(String input) {
        StringBuilder packed = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                packed.append(input.charAt(i));
                packed.append(count);
                count = 0;
            }
        }
        return packed.length() < input.length() ? packed.toString() : input;
    }
}
