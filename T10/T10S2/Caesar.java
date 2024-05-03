/**
 * Написать метод «Шифр Цезаря», с булевым параметром
 * зашифрования/расшифрования, и числовым ключом;
 */
public class Caesar {
    public static void main(String[] args) {
        System.out.println(caesar("Hello world", 5, false));
    }

    public static String caesar(String text, int key, boolean encrypt) {
        if (text == null || text.isEmpty()) return null;

        final int len = text.length();
        char[] out = new char[len];
        for (int i = 0; i < len; i++) {
            out[i] = (char) (text.charAt(i) + (encrypt ? key : -key));
        }
        return new String(out);
    }
}
