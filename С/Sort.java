import java.util.Arrays;
import java.util.Random;

/**
 * Программа для сравнения эффективности алгоритмов сортировки
 */
class Sort {
    public static void main(String[] args) {
        int array[] = new int[100000000];
        long totalTime = 0;

        for (int i = 0; i < 5; i++) {
            randomizeArray(array, 1000);
            long startTime = System.currentTimeMillis();
            sortArrayFrequency(array);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            totalTime += executionTime;
            System.out.println("Время сортировки " + (i + 1) + ": " + executionTime + " мс");
        }

        long averageTime = totalTime / 5;
        System.out.println("Среднее время выполнения метода: " + averageTime + " мс");
    }



    // заполнение массива случайными числами
    static void randomizeArray(int array[], int bound) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(bound);
    }

    static void sortArray(int array[]) {
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