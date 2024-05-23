/**
 * Описать собственную коллекцию – список на основе массива. Коллекция должна
 * иметь возможность хранить любые типы данных, иметь методы добавления и
 * удаления элементов.
 */
public class MyCollection<T> {
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
        
    }

    public T get(int index) {

    }

    public static void main(String[] args) {
        
    }
}
