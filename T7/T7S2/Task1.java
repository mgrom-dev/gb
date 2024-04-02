import java.util.Scanner;

/**
 * Посмотрите на этот код. Все ли с ним хорошо? Если нет, то скорректируйте его
 * и обоснуйте свое решение.
 */
public class Task1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] arr = new int[10];
            System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
            int index = scanner.nextInt();
            try {
                arr[index] = 1;
                System.out.println("В " + index + "-ой индекс записана цифра 1");
            } catch (Exception e) {
                System.out.println("Указан индекс за пределами массива");
            }
        }
    }
}