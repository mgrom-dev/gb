#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <pthread.h>

#define TESTS 10000   // количество тестов
#define SIZE 1000   // размер массива
#define MIN_VAL 1   // минимальное значение элемента
#define MAX_VAL 100 // максимальное значение элемента

int* generate_random_array(int size, int min_value, int max_value);
long bubble_sort(int* array, int size);
void print_array(int* array, int size);

int main() {
    srand(time(NULL)); // инициализация рандомайзера

    clock_t total_time_ms = 0;
    long iterations_in_sort;
    for (int i = 0; i < TESTS; i++) {
        int* array = generate_random_array(SIZE, MIN_VAL, MAX_VAL);

        clock_t time_start = clock(); // делаем замер времени
        iterations_in_sort = bubble_sort(array, SIZE);
        clock_t time_end = clock();
        total_time_ms += time_end - time_start;

        free(array);
    }

    printf("Count iterate: %d\nTime: %ld\n", iterations_in_sort, total_time_ms);

    return 0;
}

/**
 * генерация массива заданной длины
*/
int* generate_random_array(int size, int min_value, int max_value) {
    int* array = malloc(size * sizeof(*array));
    for (int i = 0; i < size; i++)
        array[i] = min_value + (rand() % max_value);
    return array;
}

/**
 * сортировка массива пузырьком
*/
long bubble_sort(int* array, int size) {
    int finished;
    long iteration = 0;
    do {
        finished = 1;
        for (int i = 0; i < size - 1; i++, iteration++)
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                finished = 0;
            }
    } while(!finished) ;
    return iteration;
}

/**
 * печать массива
*/
void print_array(int* array, int size) {
    for (int i = 0; i < size; i++) {
        if (i > 0) printf(" ");
        printf("%d", array[i]);
    }
}