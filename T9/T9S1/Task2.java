import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {
        int[] testNum = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        test(testNum);
    }

    public static void test(int[] numbers) {
        for (int i : numbers) {
            int[] c = { 0 };
            System.out.printf("Простые числа в диапозоне от 1 до %d\n%s\n",
                    i, findSimpleNumbers(i, c));
            System.out.println("Кол-во итерации: " + c[0]);
        }
    }

    /**
     * Написать алгоритм поиска простых чисел (делятся только на себя и
     * на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
     * вложенный for, что явно говорит о квадратичной сложности, на этом
     * стоит акцентировать внимание
     */
    public static ArrayList<Integer> findSimpleNumbers(int lastNumber, int c[]) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= lastNumber; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                c[0]++;
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple)
                arrayList.add(i);
        }
        return arrayList;
    }
}
