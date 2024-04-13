import java.util.ArrayList;
import java.util.List;

public class Demo {

    /**
     * Алгоритм вычисления числа Фибоначчи
     * 
     * @param position - позиция числа Фибоначчи, которую нужно найти
     * @param count - для подсчета сложности алгоритма
     * @return - число Фибоначчи
     */
    public static int fib(int position, int[] count) {
        count[0]++;
        if (position == 1 || position == 2) return 1;

        return fib(position - 1, count) + fib(position - 2, count);
    }

    /**
     * Алгоритм поиска шанса выпадения числа K на игральных костях
     * Для трех шестигранных кубиков
     * 
     * @param sum - сумма на игральных костях, для которой нужно узнать вероятность выпадения
     * @return - список простых чисел
     */
    public static double findChance(int sum) {
        int count = 0;
        int successResult = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i + j + k == sum) successResult++;
                    count++;
                }
            }
        }

        System.out.println("Количество операции " + count);
        return ((double) successResult) / ((double) count);
    }

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
        int[] count = {0};
        System.out.println("Число Фибонначи " + fib(13, count));
        System.out.println("Количество операции " + count[0]);
    }
}