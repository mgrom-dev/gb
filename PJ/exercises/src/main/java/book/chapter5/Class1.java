package book.chapter5;

/**
 * Создайте класс с неинициализированной ссылкой на String. Покажите, что Java
 * инициализирует ссылку значением null.
 */
public class Class1 {
    static class Test {
        String str;
    }

    public static void main(String[] args) {
        System.out.println(new Test().str);
    }
}
