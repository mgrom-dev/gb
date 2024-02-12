import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Напишите метод, который вернет содержимое текущей папки в виде массива строк.
 * Напишите метод, который запишет массив, возвращенный предыдущим методом в
 * файл.
 * Обработайте ошибки с помощью try-catch конструкции. В случае возникновения
 * исключения, оно должно записаться в лог-файл.
 */
public class Task5 {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        saveArrayStringToFile(getCureFoldeStrings(), "files.txt");
    }

    public static String[] getCureFoldeStrings() {
        File folder = new File(".");
        File[] files = folder.listFiles();
        if (files != null) {
            String[] fileNames = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                fileNames[i] = files[i].getName();
            }
            return fileNames;
        } else {
            return new String[0];
        }
    }

    public static void saveArrayStringToFile(String[] data, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String file : data)
                writer.write(file + "\n");
        } catch (IOException e) {
            // Логирование исключения в файл
            Logger logger = Logger.getLogger(Task5.class.getName());
            FileHandler fh;
            try {
                fh = new FileHandler("errors.log");
                fh.setEncoding("UTF-8");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
                // Записать исключение в лог-файл
                logger.warning("Exception occurred: " + e.getMessage());
            } catch (SecurityException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
