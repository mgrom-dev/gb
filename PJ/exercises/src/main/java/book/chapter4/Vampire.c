#include <stdio.h>
#include <string.h>

#define LEN 4

/* Задача дня:
 * Написать программу, которая находит всех чисел «вампиров», состоящих из 4
 * цифр. (Задача предложена Дэном Форханом.) Вампирами называются числа,
 * состоящие из четного количества цифр и полученные перемножением пары чисел,
 * каждое из которых содержит половину цифр результата. Цифры берутся из
 * исходного числа в произвольном порядке, завершающие нули недопустимы.
 * Примеры:
 * 1. 1260 = 21 * 60;
 * 2. 1827 = 21 * 87;
 * 3. 2187 = 27 * 81.
 */

// Сортировка массива по возрастанию
void sort(char *arr) {
  for (int i = 0; i < LEN; i++) {
    for (int j = i + 1; j < LEN; j++)
      if (arr[i] > arr[j]) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      }
  }
}

int main() {
  // ищем суммы из 4 цифр, перебирая все множители из 2 цифр
  for (int i = 10; i < 100; i++)
    for (int j = i + 1; j < 100; j++) {
      int val = i * j;
      if (val < 1000 || val > 9999)
        continue;
      // сортируем цифры суммы и цифры множителей, после сравниваем их
      char summ[LEN + 1], mult[LEN + 1];
      snprintf(summ, sizeof summ, "%d", val);
      snprintf(mult, sizeof mult, "%d%d", i, j);
      sort(summ);
      sort(mult);
      if (strcmp(summ, mult) == 0)
        // если цифры суммы и множителей совпадают, то:
        printf("Vampire number: %d = %d * %d\n", val, i, j);
    }

  return 0;
}
