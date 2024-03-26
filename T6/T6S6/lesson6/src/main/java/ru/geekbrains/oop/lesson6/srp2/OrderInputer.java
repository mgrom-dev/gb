package ru.geekbrains.oop.lesson6.srp2;

import java.util.Scanner;

// Класс отвечающий за ввод данных заказа с консоли.
public class OrderInputer {
    private static Scanner scanner = new Scanner(System.in);

    // ввод нового заказа через консоль
    public static Order inputOrderFromConsole() {
        String name = prompt("Имя клиента: ");
        String product = prompt("Продукт: ");
        int qnt = Integer.parseInt(prompt("Кол-во: "));
        int price = Integer.parseInt(prompt("Цена: "));
        return new Order(name, product, qnt, price);
    }

    private static String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
