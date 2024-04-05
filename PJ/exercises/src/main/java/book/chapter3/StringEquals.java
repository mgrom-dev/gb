package book.chapter3;

/**
 * Напишите метод, который получает два аргумента String, выполняет с ними все
 * операции логических сравнений и выводит результаты. Для операций == и !=
 * также выполните проверку equals(). Вызовите свой метод из main() для
 * нескольких разных объектов String.
 */
public class StringEquals {
    public static void main(String[] args) {
        compareStrings("Hello World", "Hello World");
        compareStrings("Hello World", new String("Hello World"));
        compareStrings("hello", "world");
    }

    static void compareStrings(String string1, String string2) {
        boolean isEqualUsingDoubleEquals = (string1 == string2);
        System.out.println("==: " + isEqualUsingDoubleEquals);

        boolean isNotEqualUsingNotEquals = (string1 != string2);
        System.out.println("!=: " + isNotEqualUsingNotEquals);

        boolean isEqualUsingEquals = string1.equals(string2);
        System.out.println("equals(): " + isEqualUsingEquals);
    }
}
