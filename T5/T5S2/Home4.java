import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * К калькулятору из предыдущего дз добавить логирование.
 */
public class Home4 {
    private static final String LOG_PATH = "calcLog.txt";
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
                    String result = String.valueOf(engine.eval(input));
                    logInFile(input + " = " + result);
                    // вызываем выполнение JavaScript с нашим примером и получаем результат
                    System.out.println("Результат: " + result);
                } catch (ScriptException e) {
                    System.out.println("Ошибка в выражении!");
                }
            }
        }
        scanner.close();
    }

    static void logInFile(String data) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tH:%1$tM %5$s %n");
        Logger logger = Logger.getLogger(Home2.class.getName());
        logger.setUseParentHandlers(false);
        FileHandler fh;
        try {
            fh = new FileHandler(LOG_PATH, true);
            fh.setEncoding("UTF-8");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            // Записать исключение в лог-файл
            logger.info(data);
            fh.close();
        } catch (SecurityException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
