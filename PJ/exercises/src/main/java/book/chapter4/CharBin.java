package book.chapter4;

/**
 * Повторите упражнение 1 из предыдущей главы, используя тернарный оператор и
 * поразрядную проверку для вывода нулей и единиц (вместо вызова метода
 * Integer.toBinaryString()).
 */
public class CharBin {
    public static void main(String[] args) {
        System.out.println(charToBin('a'));
        System.out.println(charToBin('A'));
        System.out.println(charToBin('0'));
        System.out.println(charToBin((char)('2' - '0')));
        System.out.println(charToBin('Я'));
    }

    /**
     * Приведение символа в двоичную запись с разбивкой по байтам
     * @param symbol - символ
     * @return - возвращает строку из 0 и 1
     */
    static String charToBin(char symbol) {
        String bin = "";
        while (symbol > 0) {
            bin = (symbol % 2 == 0 ? "0" : "1") + bin;
            symbol /= 2;
        }
        bin = "0".repeat(16 - bin.length()) + bin;
        int insertIndex = bin.length() / 2;
        return bin.substring(0, insertIndex) + " " + bin.substring(insertIndex);
    }
}
