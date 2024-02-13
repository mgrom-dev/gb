import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Написать метод(ы), который распарсит json из файла, используя StringBuilder,
 * создаст строки вида: Студент [фамилия] получил [оценка] по предмету
 * [предмет].
 * Пример вывода:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика
 */
public class Home3 {
    public static void main(String[] args) {
        try {
            // Чтение JSON из файла и преобразование в объект
            String json = new String(Files.readAllBytes(Paths.get("file.json")), StandardCharsets.UTF_8);
            JSONObject data = new JSONObject(json);
            JSONArray grades = data.optJSONArray("grades");
            if (grades != null) {
                for (Object item : grades) {
                    if (item instanceof JSONObject) {
                        JSONObject grade = (JSONObject) item;
                        String surname = grade.optString("фамилия").trim();
                        String mark = grade.optString("оценка").trim();
                        String subject = grade.optString("предмет").trim();
                        if (!surname.isEmpty() && !mark.isEmpty() && !subject.isEmpty()) {
                            System.out.printf("Студент %s получил %s по предмету %s\n", surname, mark, subject);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
