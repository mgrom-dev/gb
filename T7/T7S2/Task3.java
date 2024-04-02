import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный
 * массив (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно
 * будет пройти по структуре данных, если сохранено значение ?, заменить его на
 * соответствующее число.Если на каком-то месте встречается символ, отличный от
 * числа или ?, бросить подходящее исключение.Записать в тот же файл данные с
 * замененными символами ?.
 */
public class Task3 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        readData("1.txt", map);
        calcLengthName(map);
        writeData("2.txt", map);
        System.out.println(map);
    }

    public static void readData(String fileName, HashMap<String, String> map) {
        File file = new File(fileName);
        try {
            for (String line : Files.readAllLines(file.toPath())) {
                String strs[] = line.split("=");
                map.put(strs[0], strs[1]);
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void calcLengthName(HashMap<String, String> map) {
        for (Entry<String, String> key : map.entrySet()) {
            if (key.getValue().equals("?")) key.setValue(key.getKey().length() + "");
            else if (!key.getValue().matches("\\d+")) throw new IllegalArgumentException("Error incorrect value");
        }
    }

    public static void writeData(String fileName, HashMap<String, String> map) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            Files.newBufferedWriter(file.toPath(), StandardOpenOption.TRUNCATE_EXISTING);
            for (Entry<String, String> key : map.entrySet()) {
                String content = key.getKey() + "=" + key.getValue() + System.lineSeparator();
                Files.writeString(file.toPath(), content, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
