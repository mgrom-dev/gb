import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
 * 2) Замерьте время, за которое в LinkedList добавятся 10000 элементов.
 * Сравните с предыдущим.
 */
public class TimeArrayLinkedList {
    public static void main(String[] args) {
        int count = 100_000;
        System.out.println("Добавление в конец");
        long start = System.currentTimeMillis();
        getArrayListAddLast(count);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        getLinkedListAddLast(count);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("Добавление в начало");
        start = System.currentTimeMillis();
        getArrayListAddFirst(count);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        getLinkedListAddFirst(count);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("Добавление в середину");
        start = System.currentTimeMillis();
        getArrayListAddMid(count);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        getLinkedListAddMid(count);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("Добавление массивом");
        start = System.currentTimeMillis();
        getArrayAddLast(count);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        getArrayAddIntegerLast(count);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] getArrayAddLast(int count) {
        int[] arr = new int[count];
        for (int index = 0; index < count; index++)
            arr[index] = index;
        return arr;
    }

    public static Integer[] getArrayAddIntegerLast(int count) {
        Integer[] arr = new Integer[0];
        for (int index = 0; index < count; index++) {
            Integer[] temp = new Integer[index + 1];
            for (int n = 0; n < arr.length; n++)
                temp[n] = arr[n];
            arr = temp;
        }
        return arr;
    }

    public static ArrayList<Integer> getArrayListAddLast(int count) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            arrayList.add(index);
        }
        return arrayList;
    }

    public static LinkedList<Integer> getLinkedListAddLast(int count) {
        LinkedList<Integer> arrayList = new LinkedList<>();
        for (int index = 0; index < count; index++) {
            arrayList.addLast(index);
        }
        return arrayList;
    }

    public static ArrayList<Integer> getArrayListAddFirst(int count) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            arrayList.add(0, index);
        }
        return arrayList;
    }

    public static LinkedList<Integer> getLinkedListAddFirst(int count) {
        LinkedList<Integer> arrayList = new LinkedList<>();
        for (int index = 0; index < count; index++) {
            arrayList.addFirst(index);
        }
        return arrayList;
    }

    public static ArrayList<Integer> getArrayListAddMid(int count) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            arrayList.add(index / 2, index);
        }
        return arrayList;
    }

    public static LinkedList<Integer> getLinkedListAddMid(int count) {
        LinkedList<Integer> arrayList = new LinkedList<>();
        for (int index = 0; index < count; index++) {
            arrayList.add(index / 2, index);
        }
        return arrayList;
    }
}