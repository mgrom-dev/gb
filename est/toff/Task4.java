import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int[] lineInt = readLineInteger();
        int n = lineInt[0];
        int k = lineInt[1];

        lineInt = readLineInteger();

        
        
        scan.close();
    }

    private static int[] readLineInteger() {
        return Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}