import java.util.LinkedList;

/**
 * Дан LinkedList с несколькими элементами разного типа. В методе revert класса
 * LLTasks реализуйте разворот этого списка без использования встроенного
 * функционала.
 */
class LLTasks {
    public LinkedList<Object> revert(LinkedList<Object> ll) {
        // Напишите свое решение ниже
        for (int i = 0, e = ll.size() - 1; i < ll.size() / 2; i++, e--) {
            Object temp = ll.get(i);
            ll.set(i, ll.get(e));
            ll.set(e, temp);
        }
        return ll;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class RevertLinkedList {
    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();

        if (args.length == 0 || args.length != 4) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            ll.add(1);
            ll.add("One");
            ll.add(2);
            ll.add("Two");
        } else {
            ll.add(Integer.parseInt(args[0]));
            ll.add(args[1]);
            ll.add(Integer.parseInt(args[2]));
            ll.add(args[3]);
        }

        LLTasks answer = new LLTasks();
        System.out.println(ll);
        LinkedList<Object> reversedList = answer.revert(ll);
        System.out.println(reversedList);
    }
}