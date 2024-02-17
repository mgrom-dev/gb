import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * —оздать список типа ArrayList<String>.
 * ѕоместить в него как строки, так и целые числа.
 * ѕройти по списку, найти и удалить целые числа.
 */
public class StringIntegers {
    public static void main(String[] args) {
        List<String> list = createList();
        deleteNumbers(list);
        System.out.println(list);
    }

    public static List<String> createList() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "12", "cat", "5", "hi", "121"));
        return list;
    }

    public static void deleteNumbers(List<String> list) {
        for (int index = 0; index < list.size(); index++) {
            if (isNumber(list.get(index)))
                list.remove(index--);
        }
    }

    public static void deleteNumbersIterator(List<String> list) {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String nexString = iter.next();
            if (isNumber(nexString))
                iter.remove();
        }
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
