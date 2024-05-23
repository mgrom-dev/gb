import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;

/**
 * Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три
 * переменные типа (T, V, K), конструктор, принимающий на вход параметры типа (T, V,
 * K), методы возвращающие значения трех переменных. Создать метод, выводящий на консоль
 * имена классов для трех переменных класса. Наложить ограничения на параметры типа: T
 * должен реализовать интерфейс Comparable (классы оболочки, String), V должен
 * реализовать интерфейс DataInput и расширять класс InputStream, K должен расширять
 * класc Number.
 */
public class Task1<T extends Comparable<String>, V extends InputStream & DataInput, K extends Number> {
    private T t;
    private V v;
    private K k;

    public Task1(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void printTask1() {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("V: " + v.getClass().getName());
        System.out.println("K: " + k.getClass().getName());
    }

    public static void main(String[] args) {
        Task1 <String, DataInputStream, Integer> task1 = new Task1<>("Текст", new DataInputStream(System.in), 9);
        task1.printTask1();
    }
}