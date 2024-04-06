/**
 * Создайте класс Счетчик, у которого есть метод add(), увеличивающий
 * значение внутренней int переменной на 1. Сделайте так, чтобы с объектом
 * такого типа можно было работать в блоке try-with-resources. Нужно бросить
 * исключение, если работа с объектом типа счетчик была не в ресурсном try
 * и/или ресурс остался открыт. Подумайте какой тип исключения подойдет
 * лучше всего.
 */
class Counter implements AutoCloseable {
    private Integer value; // по умолчанию 0

    Counter(){
        value = 0;
    }

    void add() {
        try {
            value++;
        } catch (NullPointerException exception) {
            System.out.println("Counter is closed");
            throw exception;
        }
    }

    int getValue() {
        return value;
    }

    @Override
    public void close() throws Exception {
        value = null;
    }
}

public class Task2 {

    public static void main(String[] args) {
        try {
            add();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ok");
    }

    public static void add() throws Exception {
        Counter counter = new Counter();
        counter.add();
        System.out.println(counter.getValue());
        counter.close();
        counter.add();
    }
}
