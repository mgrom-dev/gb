import java.util.ArrayList;
import java.util.Arrays;

/**
 * Дан произвольный массив целых чисел. Создайте список ArrayList, заполненный
 * данными из этого массива. Необходимо удалить из списка четные числа и вернуть
 * результирующий.
 * 
 * Напишите свой код в методе removeEvenNumbers класса Answer. Метод
 * removeEvenNumbers принимает на вход один параметр: Integer[] arr - список
 * целых чисел, возвращает список ArrayList<Integer>
 */
public class RemoveEven {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[] {-2, -1, 0, 1, 2, 3, 4, 5};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        System.out.println(removeEvenNumbers(arr));
    }

    public static ArrayList<Integer> removeEvenNumbers(Integer[] arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer num : arr)
            if (num % 2 != 0)
                result.add(num);
        return result;
    }
}
