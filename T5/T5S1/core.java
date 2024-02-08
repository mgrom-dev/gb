import java.util.Scanner;

public class core {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Ввод из консоли целого числа
     * 
     * @param message - сообщение которое будет выводится перед началом ввода
     * @return - целое число
     */
    public static int readInteger(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введено не целое число. Попробуйте еще раз.");
            System.out.print(message);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int readInteger() {
        return readInteger("Введите целое число: ");
    }

    /**
     * Вычисление треугольного числа
     * 
     * @param n - (сумма чисел от 1 до n)
     * @return - сумма чисел
     */
    public static int triangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangle(n - 1);
        }
    }

    /**
     * Вычисление факториала числа
     * 
     * @param n - (произведение чисел от 1 до n)
     * @return - произведение чисел
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Проверяет простое ли число (натуральное число n является простым, если оно
     * отлично от 1 и делится без остатка только на 1 и на само n)
     * 
     * @param n - проверяемое число
     * @return - возвращает истину, если число простое
     */
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
