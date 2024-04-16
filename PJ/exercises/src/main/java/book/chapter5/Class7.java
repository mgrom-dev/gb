package book.chapter5;

import java.util.concurrent.TimeUnit;

/**
 * Включите в класс с именем Tank (емкость), который можно наполнить и
 * опустошить. Условие «готовности» требует, чтобы он был пуст перед очисткой.
 * Напишите метод finalize(), проверяющий это условие. В методе main()
 * протестируйте возможные случаи использования вашего класса.
 */
class Tank {
    boolean filled;
    String name;

    Tank (String name) {
        this.name = name;
        this.filled = true;
    }

    Tank fill() {
        filled = true;
        return this;
    }

    Tank free() {
        filled = false;
        return this;
    }

    @Override
    protected void finalize() throws Throwable {
        if (filled) System.out.println("Tank " + name + " not free");
    }
}

/**
 * Создайте класс с методом finalize(), который выводит сообщение. В методе
 * main() создайте объект вашего класса. Объясните поведение программы.
 * Измените предыдущее упражнение так, чтобы метод finalize() обязательно был
 * исполнен.
 */
public class Class7 {
    public static void main(String[] args) throws InterruptedException {
        new Tank("vase").fill().free();
        new Tank("bootle");
        new Tank("cup").fill();
        new Class7();

        System.gc();
        
        TimeUnit.SECONDS.sleep(1);
        System.out.println("exit of programm");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalized");
    }
}
