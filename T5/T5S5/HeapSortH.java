import java.util.Arrays;

/**
 * ���������� ����������� ��������� ��� ���������� ������� ����� ����� �
 * �������������� ���������� ����� (Heap Sort). ��������� ������ ��������
 * ��������� �������:
 * 
 * ��������� �� ���� ������ ����� ����� ��� ����������. ���� ������ ��
 * ������������, ��������� ���������� ������ �� ���������.
 * 
 * ������� �������� �������� ������ �� �����.
 * 
 * ����� ��������� ���������� ����� (Heap Sort) ��� ���������� ��������� �������
 * � ������� �����������.
 * 
 * �������� ��������������� ������ �� �����.
 * 
 * ���� ������� ������ ��������� ��� �������� ������: buildTree, ������� ������
 * ����������� ������ �� ������ �������, � heapSort, ������� ���������
 * ���������� ���������� �����.
 * 
 * ��������� ������ ���� ��������� ����������� ������, ���� ���� �� ������� ��
 * ������������� ����� � ����� ���������.
 * 
 * �� �����:
 * '5 8 12 3 6 9'
 * �� ������:
 * Initial array:
 * [5, 8, 12, 3, 6, 9]
 * Sorted array:
 * [3, 5, 6, 8, 9, 12]
 */
public class HeapSortH {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[] { 17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1 };
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}

class HeapSort {
    public static void buildTree(int[] tree, int n, int i) {
        int largest = i; // �������������� ���������� ������� ��� ������
        int l = 2 * i + 1; // ����� = 2*i + 1
        int r = 2 * i + 2; // ������ = 2*i + 2

        // ���� ����� �������� ������� ������ �����
        if (l < n && tree[l] > tree[largest]) {
            largest = l;
        }

        // ���� ������ �������� ������� ������, ��� ����� ������� ������� �� ������ ������
        if (r < n && tree[r] > tree[largest]) {
            largest = r;
        }

        // ���� ����� ������� ������� �� ������
        if (largest != i) {
            int swap = tree[i];
            tree[i] = tree[largest];
            tree[largest] = swap;

            // ���������� �������� � �������������� ���� ���������
            buildTree(tree, n, largest);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        int n = sortArray.length;

        // ���������� ���� (��������������� �������)
        for (int i = n / 2 - 1; i >= 0; i--) {
            buildTree(sortArray, n, i);
        }

        // ���������� ��������� �� ���� ���� �� ������
        for (int i = n - 1; i > 0; i--) {
            // ���������� ������� ������ � �����
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            // �������� ��������� heapify �� ����������� ����
            buildTree(sortArray, i, 0);
        }
    }
}