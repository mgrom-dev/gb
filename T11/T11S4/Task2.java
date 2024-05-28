import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * В рамках выполнения задачи необходимо:
 * Создайте коллекцию мужских и женских имен с помощью интерфейса List -
 * добавьте повторяющиеся значения
 * 
 * Получите уникальный список Set на основании List
 * Определите наименьший элемент (алфавитный порядок)
 * Определите наибольший элемент (по количеству букв в слове но в обратном
 * порядке)
 * Удалите все элементы содержащие букву ‘A’
 */
public class Task2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Max");
        names.add("Anna");
        names.add("Ira");
        names.add("Boris");
        names.add("Tanya");
        names.add("Ira");
        names.add("Max");
        names.add("Evgeni");
        names.add("Polina");
        
        System.out.println();
        System.out.println(names);
        Set<String> setNames = new HashSet<>(names);
        System.out.println(setNames);
        String smallestName = Collections.min(setNames);
        String biggestName = names.stream().max((a, b) -> a.length() - b.length()).orElse(null);
        setNames.removeIf(el -> el.contains("a"));
        System.out.println(smallestName);
        System.out.println(biggestName);
        System.out.println(setNames);
    }
}