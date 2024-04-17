package book.chapter5;

import static book.chapter2.Print.*;

/**
 * Статические инициализаторы класса Cups выполняются либо при обращении к
 * статическому объекту cl в строке с пометкой (1), либо если строка (1)
 * закомментирована — в строках (2) после снятия комментариев. Если же и
 * строка(1), и строки (2) закомментированы, static-инициализация класса Cups
 * никогда не выполнится. Также неважно, будет ли исполнена одна или обе строки
 * (2) программы — static-инициализация все равно выполняется только один раз.
 * 
 * Проверьте истинность утверждений из предыдущего абзаца.
 * 
 * Создайте класс с полем static String, инициализируемым в точке определения, и
 * другим полем, инициализируемым в блоке static. Добавьте статический метод,
 * который выводит значения полей и демонстрирует, что оба поля инициализируются
 * перед использованием.
 */

class Cup {
    Cup(int marker) {
        print("Cup(" + marker + ")");
    }

    void f(int marker) {
        print("f(" + marker + ")");
    }
}

class Cups {
    static Cup cupl;
    static Cup cup2;
    static {
        cupl = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        print("Cups()");
    }
}

class StringTest {
    static String str1 = ("string 1 init");
    static String str2;

    static {
        str2 = ("string 2 init");
    }

    static String strInit(String str) {
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str);
        return str;
    }

    static int summ(int a, int b) {
        return a + b;
    }
}

/**
 * Создайте класс с полем static String, инициализируемым в точке определения, и
 * другим полем, инициализируемым в блоке static. Добавьте статический метод,
 * который выводит значения полей и демонстрирует, что оба поля инициализируются
 * перед использованием.
 */
public class Class8 {
    public static void main(String[] args) {
        new StringTest();
        System.out.println(StringTest.summ(1, 2));
        StringTest.strInit("hello");
        print("Inside main()");
        //Cups.cupl.f(99); // (1)
    }
    //static Cups cupsl = new Cups(); // (2)
    //static Cups cups2 = new Cups(); // (2)
}
