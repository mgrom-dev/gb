package book.chapter3;

/**
 * Напишите программу с двумя константами: обе константы состоят из чередующихся
 * нулей и единиц, но у одной нулю равен младший бит, а у другой старший
 * (подсказка: константы проще всего определить в шестнадцатеричном виде).
 * Объедините эти две константы всеми возможными поразрядными операторами. Для
 * вывода результатов используйте метод Integer.toBinaryString().
 */
public class Operators {
    public static void main(String[] args) {
        int constant1 = 0b01010101;
        int constant2 = 0b10101010;
        System.out.printf("const1 in dec: %3s, bin: %8s\n", constant1, toBin(constant1));
        System.out.printf("const2 in dec: %3s, bin: %8s\n", constant2, toBin(constant2));
        System.out.printf("const1 & const2 dec: %3s, bin: %8s\n", constant1 & constant2, toBin(constant1 & constant2));
        System.out.printf("const1 | const2 dec: %3s, bin: %8s\n", constant1 | constant2, toBin(constant1 | constant2));
        System.out.printf("const1 ^ const2 dec: %3s, bin: %8s\n", constant1 ^ constant2, toBin(constant1 ^ constant2));
    }

    static String toBin(int value) {
        String bin = Integer.toBinaryString(value);
        return ("00000000" + bin).substring(bin.length());
    }
}
