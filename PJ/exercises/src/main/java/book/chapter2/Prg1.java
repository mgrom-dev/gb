package book.chapter2;

/**
 * Создайте класс с полями int и char, которые не инициализируются в
 * программе. Выведите их значения, чтобы убедиться в том, что Java выполняет
 * инициализацию по умолчанию.
 */
public class Prg1 {
    static class TestCasePrg1 {
        int value;
        char value2;
    }

    public static void main(String[] args) {
        TestCasePrg1 test = new Prg1.TestCasePrg1();
        System.out.printf("%d %d %c\n", test.value, (int)test.value2, test.value2);
    }
}