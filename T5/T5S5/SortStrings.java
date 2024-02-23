import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Взять набор строк, например,Мороз и солнце день чудесный Еще ты дремлешь друг
 * прелестный Пора красавица проснись.
 * Написать метод, который отсортирует эти строки по длине с помощью TreeMap.
 * Строки с
 * одинаковой длиной не должны “потеряться”.
 */
public class SortStrings {
    public static void main(String[] args) {
        String[] strings = {
                "Мороз и солнце день чудесный",
                "Пора красавица проснись",
                "Еще ты дремлешь друг прелестный",
                "sadasfwqedqwdsafweqdras"
        };
        System.out.println(sortStrings(strings));
    }

    public static Map<Integer, List<String>> sortStrings(String[] strings) {
        Map<Integer, List<String>> map = new TreeMap<>();
        for (String str : strings)
            map.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str);
        return map;
    }
}
