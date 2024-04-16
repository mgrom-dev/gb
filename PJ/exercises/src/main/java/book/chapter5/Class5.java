package book.chapter5;

/**
 * Создайте класс с двумя методами. В первом методе дважды вызовите второй
 * метод: один раз без ключевого слова this, а во второй с this — просто для
 * того, чтобы убедиться в работоспособности этого синтаксиса; не используйте
 * этот способ вызова на практике.
 */
public class Class5 {

    void method1() {
        method2();
        this.method2();
    }

    void method2() {
        System.out.println("Method 2");
    }
    public static void main(String[] args) {
        Class5 cl5 = new Class5();
        cl5.method1();
    }
}