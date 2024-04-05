package book.chapter3;

/**
 * Создайте класс с полем типа float. Используйте его для демонстрации
 * совмещения имен (aliasing).
 * 
 * Создайте класс с полем типа float. Используйте его для демонстрации
 * совмещения имен при вызове методов.
 */
public class CombineFloat {
    float digit;

    public static void main(String[] args) {
        CombineFloat d1 = new CombineFloat();
        CombineFloat d2 = new CombineFloat();
        d1.digit = 5.2f;
        d2.digit = 4.5f;
        System.out.printf("d1 = %f, d2 = %f\n", d1.digit, d2.digit);
        d2 = d1;
        d1.digit = 3.7f;
        System.out.printf("d1 = %f, d2 = %f\n", d1.digit, d2.digit);
        d2.digit = 3.1f;
        System.out.printf("d1 = %f, d2 = %f\n", d1.digit, d2.digit);
        setFloat(d1);
        System.out.printf("d1 = %f, d2 = %f\n", d1.digit, d2.digit);
    }

    static void setFloat(CombineFloat number) {
        number.digit = 5.9f;
    }
}