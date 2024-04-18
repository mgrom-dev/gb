package book.chapter5;

/**
 * Создайте перечисление с названиями шести типов бумажных денег. Переберите
 * результат values() с выводом каждого значения и его ordinal().
 * 
 * Напишите команду switch для перечисления из предыдущего примера. Для каждого
 * случая выведите расширенное описание конкретной валюты.
 */
enum Valute {
    EURO, RUB, DOLLAR, CRYPTA, TENGE, YEN
}

public class Money {
    public static void decribe(Valute v) {
        switch (v) {
            case EURO:
                System.out.println("Евро");
                break;
            case RUB:
                System.out.println("Рубли");
                break;
            case DOLLAR:
                System.out.println("Доллар");
                break;
            case CRYPTA:
                System.out.println("Крипта");
                break;
            case TENGE:
                System.out.println("Тенге");
                break;
            case YEN:
                System.out.println("Йены");
                break;
        }
    }

    public static void main(String[] args) {
        for (Valute v : Valute.values())
            System.out.println("Valute: " + v + " ordinal: " + v.ordinal());
        decribe(Valute.YEN);
    }
}