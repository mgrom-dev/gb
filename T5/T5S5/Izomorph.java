import java.util.HashMap;
import java.util.Map;

/**
 * Даны 2 строки, написать метод, который вернет true, если эти строки являются
 * изоморфными
 * и false, если нет. Строки изоморфны, если одну букву в первом слове можно
 * заменить на
 * некоторую букву во втором слове, при этом
 * 1. повторяющиеся буквы одного слова меняются на одну и ту же букву с
 * сохранением
 * порядка следования. (Например, add - egg изоморфны)
 * 2. буква может не меняться, а остаться такой же. (Например, note - code)
 * Пример 1:
 * Input: s = "foo", t = "bar"
 * Output: false
 * Пример 2:
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class Izomorph {
    public static void main(String[] args) {
        System.out.println(checkIsomorhic("paper", "title"));
        System.out.println(checkIsomorhic("foo", "bar"));
        System.out.println(checkIsomorhic("add", "egg"));
        System.out.println(checkIsomorhic("note", "code"));
    }

    public static boolean checkIsomorhic(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        if (word1.equals(word2))
            return true;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            if (map.containsKey(char1) && map.get(char1) != char2)
                return false;
            map.put(char1, char2);
        }
        return true;
    }
}
