package book.chapter3;

/**
 * Начните с числа, содержащего двоичную 1 в старшем бите (подсказка:
 * воспользуйтесь шестнадцатеричной константой). Используя знаковый оператор
 * сдвига вправо, сдвигайте знак до крайней правой позиции, с выводом всех
 * промежуточных результатов методом lnteger.toBinaryString().
 * 
 * Начните с числа, состоящего из двоичных единиц. Сдвиньте его влево, а затем
 * используйте беззнаковый оператор сдвига вправо по всем двоичным позициям, с
 * выводом всех промежуточных результатов методом lnteger.toBinaryString().
 * 
 * Напишите метод для вывода char в двоичном представлении. Продемонстрируйте
 * его работу на нескольких разных символах.
 */
public class Shift {
    public static void main(String[] args) {
        int number = 0b1000000000000000000000000000000;
        while (number > 0) {
            System.out.printf("%32s - %d\n", toBin(number), number);
            number >>= 1;
        }

        number = 0b1111111111111111111111111111111;
        number <<= 1;
        System.out.println("");
        while (number != 0) {
            System.out.printf("%32s - %d\n", toBin(number), number);
            number >>>= 1;
        }

        System.out.println("");
        System.out.println("'S' in bin: " + toBin('S'));
        System.out.println("'$' in bin: " + toBin('$'));
        System.out.println("'Я' in bin: " + toBin('Я'));
        System.out.println("'0' in bin: " + toBin('0'));
        System.out.println("'3' - '0' in bin: " + toBin((char)('3' - '0')));
    }

    /**
     * Представление числа в двоичном виде
     * @param value - целое число int
     * @return - возвращает строку из 0 и 1
     */
    static String toBin(int value) {
        String bin = Integer.toBinaryString(value);
        return ("0".repeat(32) + bin).substring(bin.length());
    }

    /**
     * Представление символа char в двоичном виде
     * @param symbol - символ
     * @return - возвращает строку из 0 и 1
     */
    static String toBin(char symbol) {
        String bin = Integer.toBinaryString(symbol);
        return ("0".repeat(16) + bin).substring(bin.length());
    }
}
