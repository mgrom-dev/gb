package book.chapter3;

import static book.chapter2.Print.*;

import java.util.Date;

/**
 * Напишите программу, в которой используются как «короткие», так и «длинные» команды печати.
 */
public class TestPrint {
    public static void main(String[] args) {
        System.out.println("Hello world");
        print(new Date());
    }

}
