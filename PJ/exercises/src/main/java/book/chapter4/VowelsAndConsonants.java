package book.chapter4;

//: control/VowelsAndConsonants.java 
// Демонстрация конструкции switch.

/**
 * Создайте команду switch, которая выводит сообщение в каждой секции case.
 * Разместите ее в цикле for, проверяющем все допустимые значения case. Каждая
 * секция case должна завершаться командой break. Затем удалите команды break и
 * посмотрите, что произойдет.
 */

import static book.chapter2.Print.*;

public class VowelsAndConsonants {
    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            int c = i + 'a';
            printnb((char) c + ", " + c + ": ");
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    print("гласная");
                    break;
                case 'y':
                case 'w':
                    print("условно гласная");
                    break;
                default:
                    print("согласная");
            }
        }
    }
} /* Output:
a, 97: гласная
b, 98: согласная
c, 99: согласная
d, 100: согласная
...
*///:~