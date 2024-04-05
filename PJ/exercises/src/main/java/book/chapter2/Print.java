package book.chapter2;

//: net/mindview/util/Print.java
// Print methods that can be used without
// qualifiers, using Java SE5 static imports:
import java.io.*;

/**
 * Класс Print предоставляет утилиты для вывода информации в консоль.
 */
public class Print {
  /**
   * Выводит объект в консоль с последующим переводом строки.
   * 
   * @param obj объект, который нужно вывести
   */
  public static void print(Object obj) {
    System.out.println(obj);
  }

  /**
   * Выводит перевод строки в консоль.
   */
  public static void print() {
    System.out.println();
  }

  /**
   * Выводит объект в консоль без последующего перевода строки.
   * 
   * @param obj объект, который нужно вывести
   */
  public static void printnb(Object obj) {
    System.out.print(obj);
  }

  /**
   * Предоставляет функциональность форматированного вывода, аналогичную функции
   * printf из языка программирования C.
   * 
   * @param format строка формата
   * @param args   аргументы для форматирования
   * @return объект типа PrintStream для дальнейшего вывода
   */
  public static PrintStream printf(String format, Object... args) {
    return System.out.printf(format, args);
  }
}
/// :~