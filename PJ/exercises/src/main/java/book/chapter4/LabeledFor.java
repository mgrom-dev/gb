package book.chapter4;

//: control/LabeledFor.java
// Цикл for с метками
import static book.chapter2.Print.*;

public class LabeledFor {
    public static void main(String[] args) {
        int i = 0;
        outer: // Другие команды недопустимы
        for (; true;) { // infinite loop
            inner: // Другие команды недопустимы
            for (; i < 10; i++) {
                print("i = " + i);
                if (i == 2) {
                    print("continue");
                    continue;
                }
                if (i == 3) {
                    print("break");
                    i++; // В противном случае значение i // не увеличивается
                    break;
                }
                if (i == 7) {
                    print("continue outer");
                    i++; // В противном случае значение i // не увеличивается
                    continue outer;
                }
                if (i == 8) {
                    print("break outer");
                    break outer;
                }
                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        print("continue inner");
                        continue inner;
                    }
                }
            }
        }
        // Использовать break или continue
        // с метками здесь не разрешается
    }
} /*
   * Output:
   * i = 0
   * continue inner
   * i = l
   * continue inner
   * i = 2
   * continue
   * i = 3
   * break
   * i = 4
   * continue inner
   * i = 5
   * continue inner
   * i = б
   * continue inner
   * i = 7
   * continue outer
   * i = 8
   * break outer
   */// :~