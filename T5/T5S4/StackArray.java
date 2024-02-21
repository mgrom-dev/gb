import java.util.Arrays;

/**
 * Реализовать стэк с помощью массива.
 * Нужно реализовать методы:
 * size(), empty(), push(), peek(), pop().
 */
public class StackArray {
    private static int[] array;
    private static int topIndex;

    public static void main(String[] args) {
        int capacityArray = 5;
        array = new int[capacityArray];
        topIndex = -1;

        push(5);
        push(10);
        push(7);
        System.out.println(size());
        System.out.println(empty());
        System.out.println(peek());
        pop();
        System.out.println(peek());
        System.out.println(size());
        print();
    }

    public static int size() {
        return topIndex + 1;
    }

    public static boolean empty() {
        return topIndex == -1;
    }

    public static void push(int value) {
        if (array.length <= topIndex + 1)
            array = Arrays.copyOf(array, array.length * 2);
        array[++topIndex] = value;
    }

    public static int peek() {
        return empty() ? null : array[topIndex];
    }

    public static int pop() {
        return empty() ? null : array[topIndex--];
    }

    public static void print() {
        for (int i = size() - 1; i >= 0; i--)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
