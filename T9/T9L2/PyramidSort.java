import java.util.Arrays;

public class PyramidSort {
    public static void main(String[] args) {
        int[] array = {9, 5, 4, 8, 7, 3, 1, 2, 0, 6};
        int[] counter = {0};
        pyramidSort(array, counter);
        System.out.println(Arrays.toString(array));
        System.out.println("Количество итерации: " + counter[0]);
    }

    public static void pyramidSort(int[] array, int[] counter) {
        // построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            pyramidSort(array, counter, array.length, i);
        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            counter[0]++;
            // Вызываем процедуру на уменьшенной куче
            pyramidSort(array, counter, i, 0);
        }
    }

    public static void pyramidSort(int[] array, int[] counter, int heapSize, int rootIndex) {
        counter[0]++;
        int largest = rootIndex; // Инициализируем набиольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый = 2*rootIndex + 1
        int rightChild = 2 * rootIndex + 2; // правый = 2*rootIndex + 2

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        // Если самый большой элемент не корень
        if (largest!= rootIndex) {
            int tmp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = tmp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            pyramidSort(array, counter, heapSize, largest);
        }
    }
}