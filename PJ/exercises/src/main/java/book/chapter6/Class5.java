package book.chapter6;

import book.chapter6.acess.Widget;

/**
 * Создайте библиотеку в соответствии с фрагментами кода, содержащими описания
 * access и Widget. Создайте объект Widget в классе, не входящем в пакет access.
 */
public class Class5 {
    public static void main(String[] args) {
        // дефолтный класс из другого пакета не доступен
        // new book.chapter6.acess.Utils();
        new Widget().print();
    }
}
