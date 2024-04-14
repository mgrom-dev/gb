import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать
 * количество) для количества кубиков K с количеством граней N.
 * У вас есть 2 варианта на выбор – количество кубиков может быть строго
 * ограничено (4 кубика, например), либо их количество будет динамическим. Выбор
 * за вами.
 * Если вы реализуете простой вариант, обращает внимание, что данное решение
 * имеет сложность O(n4), но если количество кубиков сделать переменной, то она
 * трансформируется в O(nk), что будет представлять собой экспоненциальную
 * сложность. Для второго решения очевидно, что его сложность O(nk) с самого
 * начала.
 */

public class Task4 {
    public static void main(String[] args) {
        int[] iteration_count = {0};
        HashMap<Integer, Double> throwCubes = findAllCombinations(2, 6, iteration_count);
        printResult(throwCubes);
        System.out.println("Count iteration: " + iteration_count[0]);
    }

    /**
     * Метод подсчитывает все возможные вариации бросков кубиков
     * 
     * @param numberOfCubes - количество кубиков
     * @param numberOfFaces - количество граней у кубиков
     * @param iteration_count - для подсчета количества итерации
     * @return - возвращает таблицу сумм очков кубиков и вероятность их выпадения
     */
    public static HashMap<Integer, Double> findAllCombinations(int numberOfCubes, int numberOfFaces, int[] iteration_count) {
        HashMap<Integer, Double> result = new HashMap<>();
        // создаем массив значений кубиков и заполняем их 1
        int[] diceValues = new int[numberOfCubes];
        for (int i = 0; i < numberOfCubes; i++)
            diceValues[i] = 1;

        int variation = 0; // общий счетчик вариации
        while (diceValues[0] <= numberOfFaces) {
            // считаем сумму всех кубиков и увеличиваем частоту ее встречаемости
            int sum = Arrays.stream(diceValues).sum();
            result.put(sum, result.getOrDefault(sum, 0D) + 1);
            variation++;

            // увеличиваем значение кубика на 1
            for (int i = numberOfCubes - 1; i >= 0; i--) {
                if (diceValues[i] == numberOfFaces && i != 0) {
                    diceValues[i] = 1;
                } else {
                    diceValues[i]++;
                    iteration_count[0]++;
                    break;
                }
            }
        }

        // считаем кол-во вариаций в процентом соотношении
        for (Map.Entry<Integer, Double> entry : result.entrySet())
            entry.setValue(entry.getValue() / variation);

        return result;
    }

    public static void printResult(HashMap<Integer, Double> variations) {
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(variations.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (Map.Entry<Integer, Double> entry : list) {
            System.out.printf("\"%2d\" probability: %8.5f %%\n", entry.getKey(), entry.getValue() * 100);
        }
    }
}