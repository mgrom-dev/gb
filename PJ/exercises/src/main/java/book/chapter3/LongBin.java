package book.chapter3;

/**
 * Покажите, что шестнадцатеричная и восьмеричная записи могут использоваться с
 * типом long. Для вывода результатов используйте метод Long.toBinaryString().
 */
public class LongBin {
    public static void main(String[] args) {
        long dec = 523; // десятичная запись
        long hex = 0x20B; // шестнадцатеричная запись
        long oct = 01013; // восьмеричная запись
        System.out.println(Long.toBinaryString(dec));
        System.out.println(Long.toBinaryString(hex));
        System.out.println(Long.toBinaryString(oct));
    }
}
