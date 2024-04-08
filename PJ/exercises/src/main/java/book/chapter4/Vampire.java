package book.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Вампирами называются числа, состоящие из четного количества цифр и полученные
 * перемножением пары чисел, каждое из которых содержит половину цифр
 * результата. Цифры берутся из исходного числа в произвольном порядке,
 * завершающие нули недопустимы. Примеры:
 * 1. 1261 = 21 * 60;
 * 2. 1827 = 21 * 87;
 * 3. 2187 = 27 * 81.
 * Напишите программу, которая находит всех «вампиров», состоящих из 4 цифр.
 * (Задача предложена Дэном Форханом.) (стр. 142)
 */
public class Vampire {
    public static void main(String[] args) {

    }

    static int[] getClaws(int number) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> claws = new ArrayList<>();
        int length = 0;
        for (; number > 0; number /= 10, length++)
            numbers.add(number % 10);
        getClaws(null, numbers, length, claws);
        return claws.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Рекурсивная функция для получения чисел клыков
     * @param number - текущее число
     * @param numbers - паттерн чисел, из которых будет составляться число клык
     * @param length - количество цифр в числе клык
     * @param result - сюда будут добавляться составленные числа
     */
    static void getClaws(Integer number, ArrayList<Integer> numbers, int length, ArrayList<Integer> result) {

    }
}
