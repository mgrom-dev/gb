import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Напишите метод, который составит строку, состоящую из 100 повторений слова
 * TEST и метод, который запишет эту строку в простой текстовый файл,
 * обработайте исключения.
 */
public class Task4 {
    public static void main(String[] args) {
        saveStringToFile(rep100String("TEST"), "out.txt");
    }

    public static String rep100String(String str) {
        return str.repeat(100);
    }

    public static void saveStringToFile(String data, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
