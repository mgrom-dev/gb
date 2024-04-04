package book.chapter2;

/**
 * Найдите фрагмент кода с классом ATypeName и сделайте из него программу,
 * пригодную для компиляции и запуска.
 */
public class ATypeName {
    private String text = "Hello user!";

    public static void main(String[] args) {
        System.out.println(new ATypeName().text);
    }
}