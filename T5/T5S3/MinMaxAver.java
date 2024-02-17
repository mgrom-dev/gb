import java.util.ArrayList;
import java.util.Arrays;

/**
 * Реализуйте метод, который принимает на вход целочисленный массив arr:
 * - Создаёт список ArrayList, заполненный числами из исходого массива arr.
 * - Сортирует список по возрастанию и выводит на экран.
 * - Находит минимальное значение в списке и выводит на экран - Minimum is
 * {число} - Находит максимальное значение в списке и выводит на экран - Maximum
 * is {число}
 * - Находит среднее арифметическое значений списка и выводит на экран - Average
 * is = {число}
 * Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers
 * принимает на вход один параметр:
 * 
 * Integer[] arr - массив целых чисел.
 */
public class MinMaxAver {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[] { 4, 2, 7, 5, 1, 3, 8, 6, 9 };
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        analyzeNumbers(arr);
    }

    public static void analyzeNumbers(Integer[] arr) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(arr));
        numbers.sort((a, b) -> a - b);
        int min = numbers.get(0);
        int max = numbers.get(numbers.size() - 1);
        float aver = numbers.stream().reduce(0, (a, b) -> a + b) / (float)numbers.size();
        System.out.println(numbers);
        System.out.printf("Minimum is %d\n", min);
        System.out.printf("Maximum is %d\n", max);
        System.out.printf("Average is %.1f\n", aver);
    }
}
