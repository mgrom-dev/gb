import java.util.Arrays;
import java.util.Random;

public class Tasks {
    /** класс под минимальное и максимальное целое значение */
    public static class MinMaxIndex {
        int min;
        int max;

        public MinMaxIndex(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }
    }
    /** класс с методами сортировки */
    public static class Sort {
        /**
         * Перенос самого большого значения элемента в массиве в правый край методом выбора
         * @param array - массив целых чисел
         * @return - новый массив 
         */
        public static Integer[] moveSelect(Integer[] array) {
            int indexMaxValue = 0;
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[indexMaxValue]) {
                    indexMaxValue = i;
                }
            }
            Integer temp = array[indexMaxValue];
            array[indexMaxValue] = array[array.length - 1];
            array[array.length - 1] = temp;
            return array;
        }
        
        /**
         * Перенос самого большого значения элемента в массиве в правый край методом пузырька
         * @param array - массив целых чисел
         * @return - новый массив 
         */
        public static Integer[] moveBubble(Integer[] array) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    Integer temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            return array;
        }

        /**
         * Сортировка массива методом выбора
         * @param array - массив целых чисел
         * @return - новый массив 
         */
        public static Integer[] move(Integer[] array) {
            for (int end = array.length; end > 0; end--) {
                int indexMaxValue = 0;
                for (int i = 1; i < end; i++) {
                    if (array[i] > array[indexMaxValue]) {
                        indexMaxValue = i;
                    }
                }
                Integer temp = array[indexMaxValue];
                array[indexMaxValue] = array[end - 1];
                array[end - 1] = temp;
            }
            return array;
        }

        /**
         * Сортировка массива методом пузырька от меньшего к большему
         * @param array - массив целых чисел
         * @return - новый массив 
         */
        public static Integer[] bubble(Integer[] array) {
            boolean repeat = true;
            while (repeat) {
                repeat = false;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        Integer temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        repeat = true;
                    }
                }
            }
            return array;
        }
    }

    public static void main(String[] args) {
        Integer[] vector1 = {1, 2, 3, 4};
        Integer[] vector2 = {5, 6, 7, 8};
        System.out.println(String.format("\nЗадача 1А. Скалярное произведение вектора %s и вектора %s, равно: %d", 
            arrayToString(vector1), arrayToString(vector2), scalarProduct(vector1, vector2)));
        
        Integer[] randomArray = Arrays.stream( new Random().ints(10, -100, 100).toArray() ).boxed().toArray( Integer[]::new );
        System.out.println(String.format("\nЗадача 1В. В массиве %s размером %d элементов, количество положительных чисел равно %d", 
           arrayToString(randomArray), randomArray.length, countPositiveNumber(randomArray)));

        randomArray = Arrays.stream( new Random().ints(10, 0, 100).toArray() ).boxed().toArray( Integer[]::new );
        System.out.println(String.format("\nЗадача 1C. В массиве %s размером %d элементов, сумма всех элементов с нечетными индексами равна %d", 
           arrayToString(randomArray), randomArray.length, summOddIndexesFromArray(randomArray)));

        System.out.println(String.format("\nЗадача 1D. В массиве %s размером %d элементов, сумма всех элементов с нечетными значениями равна %d", 
           arrayToString(randomArray), randomArray.length, summOddValuesFromArray(randomArray)));

        System.out.println(String.format("\nЗадача 2A. Дан массив %s размером %d элементов. После переноса максимального числа в конец массива методом выбора, массив стал %s", 
           arrayToString(randomArray), randomArray.length, arrayToString(Sort.moveSelect(randomArray))));
        randomArray = Arrays.stream( new Random().ints(10, 1, 100).toArray() ).boxed().toArray( Integer[]::new );
        System.out.println(String.format("Задача 2A. Дан массив %s размером %d элементов. После переноса максимального числа в конец массива методом пузырька, массив стал %s", 
           arrayToString(randomArray), randomArray.length, arrayToString(Sort.moveBubble(randomArray))));

        randomArray = Arrays.stream( new Random().ints(10, 1, 100).toArray() ).boxed().toArray( Integer[]::new );
        System.out.println(String.format("\nЗадача 2В. Дан массив %s размером %d элементов. После сортировки массива методом выбора, массив стал %s", 
           arrayToString(randomArray), randomArray.length, arrayToString(Sort.move(randomArray))));
        randomArray = Arrays.stream( new Random().ints(10, 1, 100).toArray() ).boxed().toArray( Integer[]::new );
        System.out.println(String.format("Задача 2В. Дан массив %s размером %d элементов. После сортировки массива методом пузырька, массив стал %s", 
           arrayToString(randomArray), randomArray.length, arrayToString(Sort.bubble(randomArray))));
        
        randomArray = Arrays.stream( new Random().ints(10, 1, 100).toArray() ).boxed().toArray( Integer[]::new );
        MinMaxIndex minMaxValues = minMaxValuesFromArray(randomArray);
        System.out.println(String.format("\nЗадача 2C. Дан массив %s размером %d элементов. Минимальное значение в массиве %d, максимальное значение в массиве %d", 
           arrayToString(randomArray), randomArray.length, minMaxValues.min, minMaxValues.max));

        Integer[] minMaxArray = Arrays.stream( new Random().ints(10, 0, 100).toArray() ).boxed().toArray( Integer[]::new );
        MinMaxIndex minMaxIndex = findMinAndMaxValue(minMaxArray);
        System.out.println(String.format("\nДомашнее задание 1. Задан массив %s размером %d элементов\nИндекс минимального значения в массиве %d\nИндекс максимального значения в массиве %d", 
           arrayToString(minMaxArray), minMaxArray.length, minMaxIndex.min, minMaxIndex.max));

        System.out.println(String.format("\nДомашнее задание 2. Задан массив %s размером %d элементов\nМассив в обратном порядке %s", 
           arrayToString(minMaxArray), minMaxArray.length, arrayToString(revert(minMaxArray))));

        System.out.println(String.format("\nДомашнее задание 3. Задан массив %s размером %d элементов\nСумма элементов массива, лежащих между максимальным и минимальным по значению элементами, равна: %d", 
           arrayToString(minMaxArray), minMaxArray.length, summAboveMinAndMaxArray(minMaxArray)));

        System.out.println(String.format("\nДомашнее задание 3. Задан массив %s размером %d элементов\nАльтернативный алгоритм.\nСумма элементов массива, лежащих между максимальным и минимальным по значению элементами, равна: %d", 
           arrayToString(minMaxArray), minMaxArray.length, summAboveMinAndMaxArrayAlternate(minMaxArray)));

        System.out.println(String.format("\nДомашнее задание 4. Задан массив %s размером %d элементов\nCреднее арифметическое среди всех элементов массива: %.1f\n", 
           arrayToString(minMaxArray), minMaxArray.length, average(minMaxArray)));
    }

    /**
     * Преобразование массива целых чисел в строку
     * @param array - массив целых чисел
     * @return - строка вида "1,2,3"
     */
    public static String arrayToString(Integer[] array) {
        return "[" + Arrays.stream(array)
                .map(String::valueOf)
                .reduce((x, y) -> x + ", " + y)
                .get() + "]";
    }

    /**
     * Нахождение скалярного произведения 2ух векторов произвольной размерности
     * @param vector1 - 1 вектор массив целых чисел
     * @param vector2 - 2 вектор массив целых чисел
     * @return - произведение векторов, целое число
     */
    public static Integer scalarProduct(Integer[] vector1, Integer[] vector2) {
        Integer scalarProduct = 0;
        if (vector1.length != vector2.length) {
            String message = String.format("\nОшибка! Векторы должны быть одинаковым размером \nВектор %s - размер %d\nВектор %s - размер %d", 
            arrayToString(vector1), vector1.length, arrayToString(vector2), vector2.length);
            throw new IndexOutOfBoundsException(message);
        }
        for (int i = 0; i < vector1.length; i++) {
            scalarProduct += vector1[i] * vector2[i];
        }
        return scalarProduct;
    }

    /**
     * Подсчет количества положительных чисел в массиве
     * @param array - массив целых чисел
     * @return - количество положительных чисел
     */
    public static int countPositiveNumber(Integer[] array) {
        int count = 0;
        for (Integer number : array) {
            if (number >= 0) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Сумма всех элементов массива с нечетными индексами
     * @param array - массив целых чисел
     * @return - сумма
     */
    public static int summOddIndexesFromArray(Integer[] array) {
        int summ = 0;
        for (int i = 1; i < array.length; i += 2) {
            summ += array[i];
        }
        return summ;
    }

    /**
     * Сумма всех элементов массива с нечетными значениями
     * @param array - массив целых чисел
     * @return - сумма
     */
    public static int summOddValuesFromArray(Integer[] array) {
        int summ = 0;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] % 2 == 1) {
                summ += array[i];
            }
        }
        return summ;
    }

    /**
     * Нахождение максимального и минимального элемента массива
     * @param array - массив целых чисел
     * @return - возвращает объект со свойствами min и max
     */
    public static MinMaxIndex minMaxValuesFromArray(Integer[] array) {
        MinMaxIndex result = new MinMaxIndex(array[0], array[0]);
        for (int i = 0; i < array.length; i ++) {
            if (array[i] > result.max) {
                result.max = array[i];
            }
            if (array[i] < result.min) {
                result.min = array[i];
            }
        }
        return result;
    }

    /**
     * Поиск индексов миинимального и максимального значения 
     * @param array - массив целых чисел
     * @return возвращает объект со свойствами min и max
     */
    public static MinMaxIndex findMinAndMaxValue(Integer[] array) {
        MinMaxIndex indexes = new MinMaxIndex(0, 0);
        for (int i = 1; i < array.length; i++) {
            if (array[indexes.min] > array[i]) {
                indexes.min = i;
            }
            if (array[indexes.max] < array[i]) {
                indexes.max = i;
            }
        }
        return indexes;
    }

    /**
     * Разворот массива наоборот
     * @param array - массив целых чисел
     * @return - массив в обратном порядке
     */
    public static Integer[] revert(Integer[] array) {
        Integer tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }

    /**
     * Cумма элементов массива, лежащих между максимальным и минимальным по значению элементами
     * @param array - массив целых чисел
     * @return - сумма
     */
    public static int summAboveMinAndMaxArray(Integer[] array) {
        int summ = 0;
        MinMaxIndex indexes = new MinMaxIndex(0, 0);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[indexes.max]) {
                indexes.max = i;
            }
            if (array[i] < array[indexes.min]) {
                indexes.min = i;
            }
        }
        if (indexes.min > indexes.max) {
            int temp = indexes.min;
            indexes.min = indexes.max;
            indexes.max = temp;
        }
        for (int i = indexes.min + 1; i < indexes.max; i++) {
            summ += array[i];
        }
        return summ;
    }

    /**
     * Cумма элементов массива, лежащих между максимальным и минимальным по значению элементами
     * Альтернативный метод
     * @param array - массив целых чисел
     * @return - сумма
     */
    public static int summAboveMinAndMaxArrayAlternate(Integer[] array) {
        int summ = array[0];
        int minNumber = array[0];
        int maxNumber = array[0];
        int minSumm = array[0];
        int maxSumm = array[0];
        for (int i = 1; i < array.length; i++) {
            summ += array[i];
            maxSumm += array[i];
            if (array[i] > maxNumber) {
                maxNumber = array[i];
                maxSumm = array[i];
            }
            if (array[i] < minNumber) {
                minNumber = array[i];
                minSumm = summ;
            }
        }
        summ = summ - maxSumm - minSumm;
        if (summ < 0) {
            summ = summ * -1 - minNumber - maxNumber;
        }
        return summ;
    }

    /**
     * Среднее арифметическое среди всех элементов массива
     * @param array - массив целых чисел
     * @return - среднее значение
     */
    public static double average(Integer[] array) {
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            summ += array[i];
        }
        return (double) summ / array.length;
    }
}