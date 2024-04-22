import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * Тестирование программ
 */
public class Tests {
    public static void main(String[] args) {
        clearOutput();
        task4();
    }

    /**
     * Задача D. Бумажка с числами
     */
    static void task4() {
        String[] cases = {
                "5 2\n1 2 1 3 5",
                "3 1\n99 5 85",
                "1 10\n9999"
        };
        String[] expected = {
                "16",
                "10",
                "0"
        };
        test(cases, expected, Task4::main);
    }

    /**
     * Задача C. Лифты и переговорки
     */
    static void task3v2() {
        String[] cases = {
                "5 5\n1 4 9 16 25\n2",
                "6 4\n1 2 3 6 8 25\n5"
        };
        String[] expected = {
                "24",
                "31"
        };
        test(cases, expected, Task3v2::main);
    }

    /**
     * Задача C. Лифты и переговорки
     */
    static void task3() {
        String[] cases = {
                "5 5 1 4 9 16 25 2",
                "6 4 1 2 3 6 8 25 5"
        };
        String[] expected = {
                "24",
                "31"
        };
        test(cases, expected, Task3::main);
    }

    /**
     * Очистка вывода в консоли
     */
    static void clearOutput() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Тестирование работы метода с использованием входных данных консоли
     * 
     * @param inputs   - входные данные для консоли
     * @param expected - ожидаемые значения работы метода
     * @param main - ссылка на тестируемую функцию
     */
    static void test(String[] inputs, String[] expected, Consumer<String[]> main) {
        // копируем ссылку на оригинальный выходной поток
        PrintStream originalOut = System.out;

        // проверяем каждый кейс
        boolean correctly = true;
        for (int i = 0; i < inputs.length; i++) {
            // подготавливаем среду для теста
            // устанавливаем новый входной поток с тестируемыми данными текущего кейса для
            // ввода в консоль
            System.setIn(new ByteArrayInputStream(inputs[i].getBytes()));
            // подключаемся к выходному потоку для получения данных из консоли
            ByteArrayOutputStream testStream = new ByteArrayOutputStream();
            PrintStream cloneOut = new PrintStream(testStream);
            System.setOut(cloneOut);

            // запускаем тест и получаем результат
            main.accept(null);
            String consoleOutput = testStream.toString().trim();
            boolean isOk = consoleOutput.equals(expected[i]);
            if (!isOk)
                correctly = false;

            // возвращаем выходной поток в исходное состояние и выводим результаты
            System.setOut(originalOut);
            System.out.printf("Тест: %d, входные данные: { %s }, результат: \"%s\" [%b]\n", i + 1, inputs[i].replaceAll("\n", " "),
                    consoleOutput, isOk);
        }
        System.out.println("Тестовый результат: " + (correctly ? "OK" : "Ошибка"));
    }
}
