package book.chapter5;

/**
 * Создайте класс с полем String, инициализируемым в точке определения, и другим
 * полем, инициализируемым конструктором. Чем отличаются эти два подход
 */
public class Class2 {
    static class Test {
        String str1 = "Hello";
        String str2;

        Test(String str) {
            this.str2 = str;
        }
    }

    public static void main(String[] args) {
        Test cl1 = new Test("World");
        System.out.println(cl1.str1);
        System.out.println(cl1.str2);
    }
}
