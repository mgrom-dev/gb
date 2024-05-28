import java.util.HashMap;
import java.util.Map;

/**
 * В рамках выполнения задачи необходимо:
 * 1. Создайте телефонный справочник с помощью Map - телефон это ключ, а имя
 * значение
 * 2. Найдите человека с самым маленьким номером телефона
 * 3. Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */

public class Task3 {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Ivanov", "+123");
        phoneBook.put("Petrov", "+456");
        phoneBook.put("Sidorov", "+789");
        phoneBook.put("Zaharov", "+999");
        String smallNumberPeopleName = phoneBook.entrySet().stream().min((p1, p2) -> Integer.parseInt(p1.getValue()) -  Integer.parseInt(p2.getValue())).get().getKey();
        System.out.println(smallNumberPeopleName);
        String phoneBiggestNamePeople = phoneBook.entrySet().stream().sorted((p1, p2) -> p2.getKey().compareTo(p1.getKey())).findFirst().get().getValue();
        System.out.println(phoneBiggestNamePeople);
    }
}
