import java.util.Iterator;

/**
 * Описать собственную коллекцию – список на основе массива. Коллекция должна
 * иметь возможность хранить любые типы данных, иметь методы добавления и
 * удаления элементов.
 */
public class MyCollection<T> implements Iterable<T> {
    private static final int DEFAULT_SIZE = 10;

    int size;
    int length;
    private Object[] array;

    public MyCollection() {
        this(DEFAULT_SIZE);
    }

    public MyCollection(int size) {
        length = 0;
        this.size = size;
        array = new Object[size];
    }

    public void add(T t) {
        if (length == size - 1) {
            size *= 2;
            Object[] newArray = new Object[size];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[length++] = t;
    }

    public void remove(int index) {
        if (index < 0 || index >= length) return;
        System.arraycopy(array, index + 1, array, index, length - index - 1);
        length--;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= length) return null;
        return (T) array[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MyCollection [");
        for (int i = 0; i < length; i++) {
            sb.append(i > 0 ? ", " : "").append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < array.length;
            }
            
            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }
    
    public static void main(String[] args) {
        MyCollection<Integer> collection = new MyCollection<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.remove(1);
        System.out.println(collection);
    }
}
