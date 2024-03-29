import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Программа для сравнения эффективности алгоритмов сортировки
 */
class Sort {
    public static void main(String[] args) {
        // Задаем параметры для функции
        int sizeArray = 100000000; // Размер массива (267 ms 1242MB)
        int boundRandom = 1000; // Верхняя граница для случайных чисел
        int countTest = 5; // Количество тестов
        long time = 0; // Время выполнения тестов
        Consumer<int[]> methodSort = Sort::sortArrayFrequency; // Создаем экземпляр интерфейса Consumer

        // Запускаем тесты
        for (int i = 0; i < countTest; i++)
        {
            long currentTime = sortArray(sizeArray, boundRandom, methodSort);
            if (currentTime >= 0) {
                time += currentTime;
                System.out.println("Тест № " + (i + 1) + ": " + currentTime + " мс");
            }
            else {
                time = -1;
                break;
            }
        }

        // Итоговый результат
        if (time >= 0)
            System.out.println("Среднее время выполнения: " + (time / countTest) + " мс");
        else
            System.out.println("Ошибка сортировки массива, алгоритм работает неверно");
    }

    // Метод для заполнения массива случайными значениями, возвращает время выполнения метода сортировки
    static long sortArray(int sizeArray, int boundRandom, Consumer<int[]> method)
    {
        long result = 0;
        int[] array = new int[sizeArray]; // создаем контрольный массив
        randomizeArray(array, boundRandom); // Заполняем массив случайными значениями
        int[] testArray = Arrays.copyOf(array, array.length); // создаем тестовый массив
        sortStandart(array); // Сортируем контрольный массив
        long startTime = System.currentTimeMillis();
        method.accept(testArray); // сортируем тестовый массив
        long endTime = System.currentTimeMillis();
        result = Arrays.equals(array, testArray) ? endTime - startTime : -1; // Вычисляем время выполнения метода сортировки
        return result; // Возвращаем время выполнения метода сортировки
    }

    // заполнение массива случайными числами
    static void randomizeArray(int array[], int bound) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(bound);
    }

    // стандартная функция сортировки в JAVA
    static void sortStandart(int array[]) {
        Arrays.sort(array);
    }

    static void sortArrayFrequency(int array[]) {
        int size = array.length;
        int frequency_array[] = new int[size];
        int freq_size = 0;

        for (int i = 0; i < size; i++) {
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
}