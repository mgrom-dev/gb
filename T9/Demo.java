import java.util.ArrayList;
import java.util.List;

public class Demo {

    /**
     * Алгоритм поиска простых чисел
     * 
     * @param max - максимальное число, до которого ведется поиск
     * @return - список простых чисел
     */
    public static List<Integer> findSimpleNumbers(int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i && simple; j++) {
                if (i % j == 0)
                    simple = false;
            }
            if (simple)
                result.add(i);
        }

        return result;
    }

    /**
     * Поиск доступных делителей
     * 
     * @param number - число для которого ищутся делители
     * @return - список делителей
     */
    public static List<Integer> availableDivider(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSimpleNumbers(10));
    }
}