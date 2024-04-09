package book.chapter5;

/**
 * Создайте класс без конструктора. Создайте объект этого класса в методе
 * main(), чтобы удостовериться, что конструктор по умолчанию синтезируется
 * автоматически.
 */
public class Class4 {
    static class Test {
        String info = "created";
    }

    public static void main(String[] args) {
        System.out.println(new Test().info);
    }
}
