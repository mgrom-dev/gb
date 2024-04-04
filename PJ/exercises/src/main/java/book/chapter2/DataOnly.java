package book.chapter2;

/**
 * Сделайте то же для кода с использованием класса DataOnly.
 * Измените упражнение 4 так, чтобы данным класса DataOnly присваивались
 * значения, а затем распечатайте их в методе main()
 */
public class DataOnly {
    int i;
    double d;
    boolean b;

    public static void main(String[] args) {
        DataOnly data = new DataOnly();
        data.i = 47;
        data.d = 1.1;
        data.b = false;
        System.out.printf("%d %f %s\n", data.i, data.d, data.b);
    }
}
