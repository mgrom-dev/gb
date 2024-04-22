package book.chapter6;

import static book.chapter6.debug.Debug.*;

/**
 * Создайте два пакета debug и debugoff, содержащие одинаковые классы с методом
 * debug(). Первая версия выводит на консоль свой аргумент типа String, вторая
 * не делает ничего. Используйте директиву static import для импортирования
 * класса в тестовую программу и продемонстрируйте эффект условной компиляции.
 */
public class Class3 {
    public static void main(String[] args) {
        debug("hello world!");
    }
}
