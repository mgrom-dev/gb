#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 100000000        // количество элементов массива
#define COUNT_TEST 5        // количество замеров функции сортировки
#define FUNC frequency_sort // проверяемая функция сортировки

// алгоритмы сортировки
void frequency_sort(int *array, int size);              // сортировка по повторениям элементов в один проход
void quick_sort_standart(int *array, int size);         // быстрая сортировка встроенным методом
void quick_sort(int *array, int size);                  // быстрая сортировка https://thecode.media/qsort/
void bubble_sort(int *array, int size);                 // сортировка пузырьком
void hairbrush_sort(int *array, int size);              // сортировка расческой
void swap_elements(int *array, int index1, int index2); // перестановка элементов

int compare_array(int *array1, int size1, int *array2, int size2); // сравнение массивов
void copy_array(int *source, int size1, int *target);              // копирование массива
void print_array(int *array, int size);                            // печать массива в консоль
void randomize_array(int *array, int size, int max_value);         // заполнение массива случайными числами

long test_sort_array(void (*func)(int *, int)); // тестирование работы функции сортировки массива

/**
 * Программа для сравнения эффективности алгоритмов сортировки
 */
int main()
{
    srand(time(NULL)); // инициализация рандомайзера
    long time_sum = 0;
    for (int i = 0; i < COUNT_TEST; i++)
    { // делаем замеры
        long current_time = test_sort_array(FUNC);
        if (current_time == -1)
        { // ошибка, алгоритм работает не верно
            time_sum = -1;
            break;
        }
        printf("Test: %d time: %ld ms\n", i + 1, current_time);
        time_sum += current_time;
    }
    if (time_sum == -1)
        printf("Error! Function sort not correct\n");
    else
        printf("Tests: %d average time: %ld ms\n", COUNT_TEST, time_sum / COUNT_TEST);
}

/**
 * Компаратор для работы функции сортировки
 */
int compare(const void *x1, const void *x2)
{
    return (*(int *)x1 - *(int *)x2);
}

/**
 * Быстрая сортировка встроенным методом Си
 */
void quick_sort_standart(int *array, int size)
{
    qsort(array, size, sizeof(int), compare);
}

/**
 * Сортировка повторениями
 * Условие при котором она работает: 0 <= array[i] < size
 */
void frequency_sort(int *array, int size)
{
    int *frequency_array = calloc(size, sizeof(*frequency_array)); // массив с частотой повторов значений
    int freq_size = 0;                                             // размер массива с частотой повторов

    // создаем массив повторов
    for (int i = 0; i < size; i++)
    {
        int index = array[i];
        frequency_array[index]++;
        if (index > freq_size)
            freq_size = index;
    }
    freq_size++;

    // на основе созданного массива повторов, заполняем итоговый массив
    for (int i = 0, index = 0; i < freq_size; i++)
    {
        for (int r = 0; r < frequency_array[i]; r++)
        {
            array[index++] = i;
        }
    }

    free(frequency_array);
}

/**
 * Основная функция быстрой сортировки массива
 */
void quickSort(int *arr, int size, int *result, int *resultIndex)
{
    // Если длина массива меньше двух (в нём один элемент или нет элементов вообще)
    // то возвращаем массив как есть, без обработки
    if (size < 2)
    {
        for (int i = 0; i < size; ++i)
        {
            result[*resultIndex] = arr[i];
            (*resultIndex)++;
        }
        return;
    }

    // Берём первый элемент массива как опорный
    int pivot = arr[0];
    // Будущие левые и правые части массива
    int *left = malloc(sizeof(int) * size);
    int *right = malloc(sizeof(int) * size);
    int leftSize = 0, rightSize = 0;

    // Перебираем весь массив по порядку
    for (int i = 1; i < size; ++i)
    {
        // Если опорный элемент больше текущего
        if (pivot > arr[i])
        {
            // То добавляем текущий элемент в левую часть
            left[leftSize++] = arr[i];
        }
        else
        {
            // В противном случае добавляем текущий элемент в правую часть
            right[rightSize++] = arr[i];
        }
    }

    // Отправляем на рекурсивную обработку левую и правую части массива
    quickSort(left, leftSize, result, resultIndex);

    // Добавляем опорный элемент в результирующий массив
    result[*resultIndex] = pivot;
    (*resultIndex)++;

    quickSort(right, rightSize, result, resultIndex);

    // Освобождаем память
    free(left);
    free(right);
}

/**
 * Быстрая сортировка, подготовка
 */
void quick_sort(int *array, int size)
{
    int *sortedArray = malloc(sizeof(int) * size);
    int resultIndex = 0;

    quickSort(array, size, sortedArray, &resultIndex);
    for (int i = 0; i < size; i++)
    {
        array[i] = sortedArray[i];
    }

    free(sortedArray);
}

/**
 * Сортировка пузырьком
 */
void bubble_sort(int *array, int size)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = i + 1; j < size; j++)
        {
            if (array[i] > array[j])
            {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }
    }
}

/**
 * Сортировка расческой. Работает быстрее пузырьковой сортировки, за счет меньшего количества операции перестановок.
 */
void hairbrush_sort(int *array, int size)
{
    const double factor = 1.247; // расстояние между элементами
    double gapFactor = size / factor;
    while (gapFactor > 1)
    {
        for (int i = 0, j = gapFactor; j < size; i++, j++)
            if (array[i] > array[j])
                swap_elements(array, i, j);
        gapFactor /= factor;
    }
}

/**
 * Поменять элементы массива, местами
 */
void swap_elements(int *array, int index1, int index2)
{
    int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
}

/**
 * Печать массива
 */
void print_array(int *array, int size)
{
    for (int i = 0; i < size; i++)
    {
        if (i > 0)
            printf(" ", array[i]);
        printf("%d", array[i]);
    }
}

/**
 * Заполнение массива случайными значениями
 */
void randomize_array(int *array, int size, int max_value)
{
    for (int i = 0; i < size; i++)
        array[i] = rand() % (max_value + 1);
}

/**
 * Сравнение двух массивов
 */
int compare_array(int *array1, int size1, int *array2, int size2)
{
    int result = -1;
    if (size1 == size2)
    {
        result = 0;
        for (int i = 0; i < size1; i++)
            if (array1[i] != array2[i])
            {
                result = -1;
                break;
            }
    }
    return result;
}

/**
 * Копирование массива array1 в массив array2
 */
void copy_array(int *source, int size1, int *target)
{
    for (int i = 0; i < size1; i++)
        target[i] = source[i];
}

/**
 * Тестирование времени работы функции сортировки массива
 */
long test_sort_array(void (*func)(int *, int))
{
    int *main_array = malloc(sizeof(*main_array) * SIZE); // главный массив, в котором значения точно правильно отсортированы
    int *test_array = malloc(sizeof(*test_array) * SIZE); // тестируемый массив, на котором проверяется быстродействие и правильность сортировки
    randomize_array(main_array, SIZE, 1000);              // заполняем главный массив случайными значениями
    copy_array(main_array, SIZE, test_array);             // копируем главный массив в тестируемый
    frequency_sort(main_array, SIZE);                     // сортируем главный массив правильным алгоритмом

    clock_t time_start = clock(); // делаем замер времени
    func(test_array, SIZE);
    clock_t time_end = clock();

    int correct = compare_array(main_array, SIZE, test_array, SIZE); // проверяем правильность сортировки
    free(main_array);
    free(test_array);
    return correct == 0 ? time_end - time_start : -1;
}