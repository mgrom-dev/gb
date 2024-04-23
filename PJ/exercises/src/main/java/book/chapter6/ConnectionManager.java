package book.chapter6;

import book.chapter6.ConnectionManager.Connection;

/**
 * По образцу примера Lunch.java создайте класс с именем ConnectionManager,
 * который управляет фиксированным массивом объектов Connection. Программист-
 * клиент не должен напрямую создавать объекты Connection, а может получать их
 * только с помощью статического метода в классе ConnectionManager. Когда запас
 * объектов у класса ConnectionManager будет исчерпан, он должен вернуть ссылку
 * null. Протестируйте классы в методе main().
 */
public class ConnectionManager {
    public static class Connection {
        public String name;

        private Connection(String name) {
            this.name = name;
        }

        
        @Override
        public String toString() {
            return name;
        }
    }

    private static int length = 0;
    private static int limit = 3;
    private static Connection[] array = new Connection[limit];

    private ConnectionManager() {}

    public static Connection makeConnection(String name) {
        if (length >= limit)
            return null;
        
        Connection newConnection = new Connection(name);
        array[length++] = newConnection;
        return newConnection;
    }

    public static Connection[] getConnections() {
        return array;
    }

    public static void main(String[] args) {
        test.run();
    }
}

// тестируем класс
class test {
    public static void run() {
        // конструктор не видно вне класса
        // new Connection("first connection");
        System.out.println(ConnectionManager.makeConnection("1 connection"));
        System.out.println(ConnectionManager.makeConnection("2 connection"));
        System.out.println(ConnectionManager.makeConnection("3 connection"));
        System.out.println(ConnectionManager.makeConnection("4 connection"));
        for (Connection connection: ConnectionManager.getConnections()) {
            System.out.println(connection);
        }
    }
}