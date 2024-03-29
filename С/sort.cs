using System;
using System.Linq;
using System.Diagnostics;

class Program
{

    static void Main(string[] args)
    {
        // Задаем параметры для функции
        int sizeArray = 100000000; // Размер массива (380 ms 784MB)
        int boundRandom = 1000; // Верхняя граница для случайных чисел
        int countTest = 5; // Количество тестов
        long time = 0; // Время выполнения тестов
        Action<int[]> methodSort = SortFrequency; // Проверяемая функция сортировки

        // Запускаем тесты
        for (int i = 0; i < countTest; i++)
        {
            long currentTime = SortArray(sizeArray, boundRandom, methodSort);
            if (currentTime >= 0) {
                time += currentTime;
                Console.WriteLine("Тест № " + (i + 1) + ": " + currentTime + " мс");
            }
            else {
                time = -1;
                break;
            }
        }

        // Итоговый результат
        if (time >= 0)
            Console.WriteLine("Среднее время выполнения: " + (time / countTest) + " мс");
        else
            Console.WriteLine("Ошибка сортировки массива, алгоритм работает неверно");
    }

    // Метод для заполнения массива случайными значениями, возвращает время выполнения метода сортировки
    static long SortArray(int sizeArray, int boundRandom, Action<int[]> method)
    {
        long result = 0;
        int[] array = new int[sizeArray]; // создаем контрольный массив
        int[] testArray = new int[sizeArray]; // создаем тестовый массив
        FillArrayWithRandomNumbers(array, boundRandom); // Заполняем массив случайными значениями
        Array.Copy(array, testArray, array.Length); // Копируем массив в тестовый массив
        SortStandart(array); // Сортируем контрольный массив
        Stopwatch stopwatch = Stopwatch.StartNew(); // создаем счётчик
        method(testArray); // сортируем тестовый массив
        stopwatch.Stop(); // останавливаем счётчик
        result = array.SequenceEqual(testArray) ? stopwatch.ElapsedMilliseconds : -1; // Вычисляем время выполнения метода сортировки
        return result; // Возвращаем время выполнения метода сортировки
    }

    // Сортировка пузырьком
    static void SortBubble(int[] array)
    {
        int n = array.Length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    // Обмен значений
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // сортировка повторами
    static void SortFrequency(int[] array)
    {
        int size = array.Length;
        int[] frequency_array = new int[size]; // массив с частотой повторов значений
        int freq_size = 0;                     // размер массива с частотой повторов

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
    }

    // Стандартный метод сортировки массива
    static void SortStandart(int[] array)
    {
        Array.Sort(array);
    }

    // Метод для заполнения массива случайными значениями
    static void FillArrayWithRandomNumbers(int[] array, int boundRandom)
    {
        Random random = new Random();
        for (int i = 0; i < array.Length; i++)
            array[i] = random.Next(0, boundRandom);
    }
}