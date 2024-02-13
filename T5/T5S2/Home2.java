import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после
 * каждой итерации запишите в лог-файл.
 */
public class Home2 {
    private static final String LOG_PATH = "bubbleLog.txt";

    public static void main(String[] args) {
        bubbleSort(new int[]{9, 4, 8, 3, 1});
    }

    static void bubbleSort(int[] mas) {
        boolean isReplaced = false;
        for (int i = 0, len = mas.length; i < len; i++) {
            isReplaced = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    int temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                    isReplaced = true;
                }
            }
            logInFile(Arrays.toString(mas));
            if (!isReplaced)
                break;
        }
    }

    static void logInFile(String data) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
              "%1$tF %1$tH:%1$tM %5$s %n");
        Logger logger = Logger.getLogger(Home2.class.getName());
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