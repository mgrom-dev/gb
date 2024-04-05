//: control/IfElse2.java

package book.chapter4;

import static book.chapter2.Print.*;

/**
 * Измените метод test() так, чтобы он получал два дополнительных аргумента
 * begin и end, а значение testval проверялось на принадлежность к диапазону
 * [begin, end] (с включением границ).
 */
public class IfElse2 {
    static int test(int testval, int target) {
        if (testval > target) 
            return +1;
        else if(testval < target) 
            return -1;
        else
            return 0; // Одинаковые значения
    }

    static int test(int testval, int begin, int end) {
        if (testval > end) 
            return +1;
        else if(testval < begin) 
            return -1;
        else
            return 0; // Одинаковые значения
    }

    public static void main(String[] args) { 
        print(test(10, 5)); 
        print(test(5, 10));
        print(test(5, 5));
        print(test(5, 5, 10));
        print(test(5, 6, 10));
        print(test(5, 2, 4));
    }
} /* Output:
1
-1
0
0
-1
1
*///:~
