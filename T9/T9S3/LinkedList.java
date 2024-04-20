import java.util.Comparator;

/**
 * Связанный список
 * 
 * @param <T>
 */
public class LinkedList<T> {
    public Node head;

    /**
     * Добавляет элемент в связанный список
     * 
     * @param value
     */
    public void add(T value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    /**
     * Добавляет элемент в конец связанного списка
     * 
     * @param value
     */
    public void addLast(T value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    /**
     * Удалить последний элемент из списка
     * 
     * @return
     */
    public void removeLast() {
        if (head == null) return ;
        Node current = head;
        while (current.next != null) {
            if (current.next.next == null) {
                current.next = null;
                return;
            }
            current = current.next;
        }
        
        head = null;
    }

    /**
     * Удалить первый элемент из списка
     * 
     * @return
     */
    public void removeFirst() {
        if (head != null)
            head = head.next;
    }

    /**
     * Поиск элемента в связанном списке по значению
     * 
     * @param value
     * @return
     */
    public boolean contains(T value) {
        Node node = head;
        while (node != null) {
            if (node.value.equals(value))
                return true;
            node = node.next;
        }
        return false;
    }

    /**
     * сортировка списка
     */
    public void sort(Comparator<T> comparator) {
        Node node = head;
        while (node != null) {
            Node minValNode = node;
            Node minValNodeNext = node.next;
            while (minValNodeNext != null) {
                if (comparator.compare(minValNode.value, minValNodeNext.value) > 0) {
                    minValNode = minValNodeNext;
                }
                minValNodeNext = minValNodeNext.next;
            }
            if (minValNode != node) {
                T value = minValNode.value;
                minValNode.value = node.value;
                node.value = value;
            }
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        Node node = head;
        while (node != null) {
            sBuilder.append(node.value).append('\n');
            node = node.next;
        }
        return sBuilder.toString();
    }

    /**
     * Узел связанного списка
     */
    public class Node {
        Node next;
        @SuppressWarnings("unused")
        T value;
    }
}