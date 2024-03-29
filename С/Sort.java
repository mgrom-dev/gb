import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

/**
 * ��������� ��� ��������� ������������� ���������� ����������
 */
class Sort {
    public static void main(String[] args) {
        // ������ ��������� ��� �������
        int sizeArray = 100000000; // ������ ������� (267 ms 1242MB)
        int boundRandom = 1000; // ������� ������� ��� ��������� �����
        int countTest = 5; // ���������� ������
        long time = 0; // ����� ���������� ������
        Consumer<int[]> methodSort = Sort::sortArrayFrequency; // ������� ��������� ���������� Consumer

        // ��������� �����
        for (int i = 0; i < countTest; i++)
        {
            long currentTime = sortArray(sizeArray, boundRandom, methodSort);
            if (currentTime >= 0) {
                time += currentTime;
                System.out.println("���� � " + (i + 1) + ": " + currentTime + " ��");
            }
            else {
                time = -1;
                break;
            }
        }

        // �������� ���������
        if (time >= 0)
            System.out.println("������� ����� ����������: " + (time / countTest) + " ��");
        else
            System.out.println("������ ���������� �������, �������� �������� �������");
    }

    // ����� ��� ���������� ������� ���������� ����������, ���������� ����� ���������� ������ ����������
    static long sortArray(int sizeArray, int boundRandom, Consumer<int[]> method)
    {
        long result = 0;
        int[] array = new int[sizeArray]; // ������� ����������� ������
        randomizeArray(array, boundRandom); // ��������� ������ ���������� ����������
        int[] testArray = Arrays.copyOf(array, array.length); // ������� �������� ������
        sortStandart(array); // ��������� ����������� ������
        long startTime = System.currentTimeMillis();
        method.accept(testArray); // ��������� �������� ������
        long endTime = System.currentTimeMillis();
        result = Arrays.equals(array, testArray) ? endTime - startTime : -1; // ��������� ����� ���������� ������ ����������
        return result; // ���������� ����� ���������� ������ ����������
    }

    // ���������� ������� ���������� �������
    static void randomizeArray(int array[], int bound) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(bound);
    }

    // ����������� ������� ���������� � JAVA
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

        // �� ������ ���������� ������� ��������, ��������� �������� ������
        for (int i = 0, index = 0; i < freq_size; i++)
        {
            for (int r = 0; r < frequency_array[i]; r++)
            {
                array[index++] = i;
            }
        }
    }
}