import java.util.Scanner;

/**
 * Формат входных данных
 * 
 * Вводится A,B,C,D (1≤A,B,C,D≤100) — стоимость тарифа Кости, размер тарифа
 * Кости, стоимость каждого лишнего мегабайта, размер интернет-трафика Кости в
 * следующем месяце. Числа во входном файле разделены пробелами.
 * 
 * Формат выходных данных
 * Выведите одно натуральное число — суммарные расходы Кости на интернет.
 * public class Main {
 */
class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int o = d - b > 0 ? d - b : 0;
        System.out.println(a + c * o);
        scan.close();
    }
}