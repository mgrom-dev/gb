import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] h = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scan.close();
        if (n % 2 != 0) {
            System.out.println("-1 -1");
        }
    }

}