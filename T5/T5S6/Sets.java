import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1. Создайте HashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6,
 * 3}.
 * Распечатайте содержимое данного множества.
 * 2. Создайте LinkedHashSet, заполните его следующими числами: {1, 2, 3, 2, 4,
 * 5,
 * 6, 3}. Распечатайте содержимое данного множества.
 * 3. Создайте TreeSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6,
 * 3}.
 * Распечатайте содержимое данного множества.
 */
public class Sets {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        hashSet.addAll(Arrays.asList(1, 3, 3, 2, 4, 5, 6, 3));
        System.out.println(hashSet);
        linkedHashSet.addAll(Arrays.asList(1, 3, 3, 2, 4, 5, 6, 3));
        System.out.println(linkedHashSet);
        treeSet.addAll(List.of(1, 3, 3, 2, 4, 5, 6, 3));
        System.out.println(treeSet);
    }
}