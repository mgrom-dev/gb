import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

/**
 * 1) Написать метод, который принимает массив элементов, помещает их в стэк
 * и выводит на консоль содержимое стэка.
 * 2) Написать метод, который принимает массив элементов, помещает их в
 * очередь и выводит на консоль содержимое очереди.
 */
public class StackQueue {
    public static void main(String[] args) {
        Integer[] array = { 0, 2, 5, 10, 2, 7, 6, 55, 22, 11 };
        addPrintStack(array);
        addPrintQueue(array);
    }

    public static void addPrintStack(Integer[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(array));
        while(!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }

    public static void addPrintQueue(Integer[] array) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.addAll(Arrays.asList(array));
        System.out.println(queue);
    }
}
