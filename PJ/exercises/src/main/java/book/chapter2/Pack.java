package book.chapter2;

/**
 * Напишите программу, демонстрирующую автоматическую упаковку примитивных
 * типов.
 */
public class Pack {
    public static void main(String[] args) {
        int i = 10;
        float f = 5.2f;
        char c = 'H';
        boolean b = true;
        printValues(i, f, c, b);
    }

    public static void printValues(Integer i, Float f, Character c, Boolean b) {
        System.out.printf("Integer: %d, Float: %f, Character: %c, Boolean: %s\n", i, f, c, b);
        System.out.printf("i: %s, f: %s, c: %s, b: %s\n", i.getClass(), f.getClass(), c.getClass(), b.getClass());
    }
}
