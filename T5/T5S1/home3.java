import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class home3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // создаем экземпляр класса JavaScript для работы с eval
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        String input = "";
        while (!input.toLowerCase().contains("exit")) {
            System.out.println("Введите что нужно вычислить, например: 2+2, или 2+2*2, для выхода введите exit:");
            input = scanner.nextLine();
            // проверяем соответсвует ли строка математическому примеру
            if (!input.matches(".*[^ 0-9+\\-*/].*")) {
                try {
                    // вызываем выполнение JavaScript с нашим примером и получаем результат
                    System.out.println("Результат: " + engine.eval(input));
                } catch (ScriptException e) {
                    System.out.println("Ошибка в выражении!");
                }
            }
        }
        scanner.close();
    }
}
