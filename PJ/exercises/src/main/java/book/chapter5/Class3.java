package book.chapter5;

/**
 * Создайте класс с конструктором по умолчанию (без параметров), который выводит
 * на экран сообщение. Создайте объект этого класса.
 * Добавьте к классу из упражнения 3 перегруженный конструктор, принимающий в
 * качестве параметра строку (String) и распечатывающий ее вместе с сообщением.
 */
public class Class3 {
    static class Test {
        Test() {
            System.out.println("Default constructor");
        }

        Test(String messsage) {
            System.out.println("Args constructor, message: \"" + messsage + "\"");
        }
    }

    public static void main(String[] args) {
        new Test();
        new Test("Hello World!");
    }
}
