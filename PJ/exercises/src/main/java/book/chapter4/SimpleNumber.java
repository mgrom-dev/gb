package book.chapter4;

/**
 * Напишите программу, использующую два вложенных цикла for и оператор остатка
 * (%) для поиска и вывода простых чисел (то есть целых чисел, не делящихся
 * нацело ни на какое другое число, кроме себя и 1).
 */
public class SimpleNumber {
    public static void main(String[] args) {
        for (int i = 2, count = 0; count < 100; i++) {
            boolean is_simple = true;
            for (int j = 2; j < i; j++) {
                if (i % 1 != 0 || i % j == 0) {
                    is_simple = false;
                    break;
                }
            }
            if (is_simple) {
                count++;
                System.out.println("simple number: " + i);
            }
        }
    }
}
