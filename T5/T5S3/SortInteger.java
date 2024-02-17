import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Заполнить список десятью случайными числами.
 * Отсортировать список методом sort() и вывести его на
 * экран.
 */
public class SortInteger {
    public static void main(String[] args) {
        List<Integer> list = getRandomList(10, 10);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    public static List<Integer> getRandomList(int size, int max) {
        List<Integer> list = new ArrayList<>(size);
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(max));
        }
        return list;
    }
}
