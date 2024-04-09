#include <stdio.h>
#include <string.h>

/* Задача дня:
 * Написать программу, которая находит всех чисел «вампиров», состоящих из 4 цифр.
 * (Задача предложена Дэном Форханом.)
 * Вампирами называются числа, состоящие из четного количества цифр и полученные
 * перемножением пары чисел, каждое из которых содержит половину цифр
 * результата. Цифры берутся из исходного числа в произвольном порядке,
 * завершающие нули недопустимы. Примеры:
 * 1. 1260 = 21 * 60;
 * 2. 1827 = 21 * 87;
 * 3. 2187 = 27 * 81.
 */

void sort(char arr[5])
{
    int siz = sizeof arr;
    for (int i = 0; i < siz; i++)
    {
        for (int j = i + 1; j < siz; j++)
        {
            if (arr[i] > arr[j])
            {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}

int main()
{
    for (int i = 10; i < 100; i++)
    {
        for (int j = i + 1; j < 100; j++)
        {
            int val = i * j;
            if (val < 1000 || val > 9999)
                continue;
            char summ[5], mult[5];
            snprintf(summ, sizeof summ, "%d", val);
            snprintf(mult, sizeof mult, "%d%d", i, j);
            sort(summ);
            sort(mult);
            if (strcmp(summ, mult) == 0)
                printf("Vampire number: %d = %d * %d\n", val, i, j);
        }
    }

    return 0;
}
