package ru.geekbrains.oop.lesson6.srp2;

public class Program {

    /**
     * @TODO: Переработать структуру приложения Order, приложение должно
     *        соответствовать
     *        принципу SRP. Принцип SRP (Single Responsibility Principle) - принцип
     *        единственной ответственности, гласит что каждый класс должен быть
     *        ответственен только за один аспект функциональности программы.
     * @DONE: класс Order разбит на 3 класса
     */
    public static void main(String[] args) {
        System.out.println("Укажите параметры заказа:");
        Order order1 = OrderInputer.inputOrderFromConsole();
        OrderSaver.saveOrderToJson(order1);
    }

}
