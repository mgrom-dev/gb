
//: object/HelloDate.java
import java.util.*;

/**
 * Первая программа-пример книги.
 * Выводит строку и текущее число.
 * 
 * @author Брюс Эккель
 * @author www.MindView.net
 * @version 4.0
 */
public class HelloDate {
    /**
     * Точка входа в класс и приложение
     * 
     * @param args Массив строковых аргументов
     * @throws Exception Исключения не выдаются
     */
    public static void main(String[] args) {
        System.out.println("Пpивeт, сегодня: ");
        System.out.println(new Date());
    }
}
/*
 * Output: (55% match)
 * Привет, сегодня:
 * Wed Oct 05 14:39:36 MDT 2005
 */// :~