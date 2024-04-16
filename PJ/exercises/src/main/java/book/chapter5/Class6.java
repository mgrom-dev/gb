package book.chapter5;

/**
 * Подготовьте класс с двумя (перегруженными) конструкторами. Используя ключевое
 * слово this, вызовите второй конструктор из первого
 */
public class Class6 {
    Class6(String message) {
        System.out.println("Class 6 " + message);
    }

    Class6() {
        this("created");
    }

    public static void main(String[] args) {
        new Class6();
    }
}
