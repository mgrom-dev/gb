import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Создать структуру для хранения Номеров паспортов и Фамилий
 * сотрудников организации.
 * 123456 Иванов
 * 321456 Васильев
 * 234561 Петрова
 * 234432 Иванов
 * 654321 Петрова
 * 345678 Иванов
 * Вывести данные по сотрудникам с фамилией Иванов.
 */
public class Passport {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new LinkedHashMap<>();
        // Map<Integer, String> hashMap = new TreeMap<>(); // элементы будут остортированы по ключу
        // Map<Integer, String> hashMap = new HashMap<>(); // элементы будут отсортированы по хэшу
        hashMap.put(123456, "Иванов");
        hashMap.put(321456, "Васильев");
        hashMap.put(234561, "Петрова");
        hashMap.put(234432, "Иванов");
        hashMap.put(654321, "Петрова");
        hashMap.put(345678, "Иванов");

        for (Integer passportNum : hashMap.keySet()) {
            System.out.printf("Номер паспорта: %s, Фамилия: %s\n", passportNum, hashMap.get(passportNum));
        }
    }

    public static void printTargetName(String targetName, Map<Integer, String> map) {
        System.out.printf("Данные по сотрудникам с фамилией: %s\n", targetName);
        for (Integer passportNum : map.keySet()) {
            if (map.get(passportNum).equals(targetName))
                System.out.printf("Номер паспорта: %s, Фамилия: %s\n", passportNum, map.get(passportNum));
        }
    }
}