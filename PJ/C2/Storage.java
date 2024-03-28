/**
 * Напишите программу, включающую метод storage(), приведенный ранее в этой
 * главе
 */
public class Storage {
    public static void main(String[] args) {
        String str = "new string";
        int size = storage(str);
        System.out.printf("\"%s\", length = %d byte\n", str, size);
    }

    static int storage(String s) {
        return s.length() * 2;
    }
}
