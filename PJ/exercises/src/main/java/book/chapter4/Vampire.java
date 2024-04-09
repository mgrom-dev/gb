package book.chapter4;

import java.util.Arrays;

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
        int val = 0;
        String[] str1 = null;
        String[] str2 = null;
        int count = 0; // количество операций
        int sum = 0; // количество номеров вампиров
        for (int i = 10; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                val = i * j;
                if (val < 1000 || val > 9999)
                    continue;
                count++;
                str1 = String.valueOf(val).split("");
                str2 = (String.valueOf(i) + String.valueOf(j)).split("");
                Arrays.sort(str1);
                Arrays.sort(str2);
                if (Arrays.equals(str1, str2)) {
                    sum++;
                    System.out.println(sum + ". Число вампир: " + i + " * " + j + " = " + val);
                }
            }
        }
        System.out.println("Количество проверок " + count);
        System.out.println("Количество найденных чисел вампиров: " + sum);
    }
}
