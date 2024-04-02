
/**
 * Напишите программу, которая принимает символ a в качестве аргумента и
 * выполняет следующую проверку:
 * если символ a равен пробелу ' ', программа должна выбрасывать исключение с
 * сообщением
 * "Пустая строка введена.".
 * В противном случае программа должна возвращать сообщение
 * "Ваш ввод - [символ]", где [символ] заменяется на введенный символ a.
 * На входе:
 * '0'
 * На выходе:
 * Result: Your input was - 0
 */
class Expr {
    public static String expr(char a) throws Exception {
        if (a ==' ') throw new Exception("Empty string has been input.");
        return "Your input was - " + a;
    }
}

public class Home4 {
    public static void main(String[] args) {
        char a;

        if (args.length == 0) {
            a = 'J'; // Значение по умолчанию, если аргументы не были предоставлены
        } else {
            a = args[0].charAt(0); // Преобразуйте первый аргумент командной строки в символ
        }

        try {
            String result = Expr.expr(a);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
