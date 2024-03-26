package ru.geekbrains.oop.lesson6.srp2;

/**
 * Разбиваем класс на 3 класса:
 * Класс отвечающий за ввод данных заказа с консоли.
 * Класс отвечающий за сохранение заказа в формате JSON.
 * Класс отвечающий за хранение данных о заказе.
 */
public class Order {

    private String clientName;

    private String product;

    private int qnt;

    private int price;

    public Order(String clientName, String product, int qnt, int price) {
        this.clientName = clientName;
        this.product = product;
        this.qnt = qnt;
        this.price = price;
    }

    public Order() {

    }

    public String getClientName() {
        return clientName;
    }

    public String getProduct() {
        return product;
    }

    public int getQnt() {
        return qnt;
    }

    public int getPrice() {
        return price;
    }

}
