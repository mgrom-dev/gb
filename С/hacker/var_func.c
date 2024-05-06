#include <stdarg.h>
#include <stdio.h>

/* общая обертка для 3 функции с переменным количеством аргуметов */
int var_func(int (*f)(int, int), int count, ...) {
    va_list args;
    va_start(args, count);

    /* получаем первый аргумент */
    int result = va_arg(args, int);
    while (--count) result = f(result, va_arg(args, int));

    va_end(args);
    return result;
}

/* меняем сигнатуру функции */
int sum(int a, int b) { return a + b; }
int min(int a, int b) { return a < b ? a : b; }
int max(int a, int b) { return a > b ? a : b; }

/* меняем ниже по тексту функции sum, min, max на другие с общей оберткой */
#define sum(c, ...) var_func(&sum, c, __VA_ARGS__)
#define min(c, ...) var_func(&min, c, __VA_ARGS__)
#define max(c, ...) var_func(&max, c, __VA_ARGS__)

int main() {
    int array[] = {1, 2, 3, 4, 5};

    /* вызываем разные функции с переменным количеством аргументов */
    int array_sum = sum(5, array[0], array[1], array[2], array[3], array[4]);
    int array_min = min(5, array[0], array[1], array[2], array[3], array[4]);
    int array_max = max(5, array[0], array[1], array[2], array[3], array[4]);

    printf("sum: %d\n", array_sum);  // 15
    printf("min: %d\n", array_min);  // 1
    printf("max: %d\n", array_max);  // 5

    return 0;
}