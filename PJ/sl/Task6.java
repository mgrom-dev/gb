import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] wrongEvenPos = new int[n];
        int[] wrongOddPos = new int[n];
        int evenCount = 0, oddCount = 0;
        boolean not_possible = false;

        for (int i = 0; i < n; i++) {
            boolean isHeightEven = (a[i] % 2 == 0);
            boolean isPosEven = ((i + 1) % 2 == 0);
            if (isPosEven && !isHeightEven) {
                wrongEvenPos[evenCount++] = i;
            } else if (!isPosEven && isHeightEven) {
                wrongOddPos[oddCount++] = i;
            }
        }

        if (evenCount != oddCount || evenCount == 0) {
            not_possible = true;
        } else if (evenCount == 1) {
            int i = wrongEvenPos[0];
            int j = wrongOddPos[0];
            if ((a[j] % 2 == 0) && (a[i] % 2 != 0)) {
                int min = Math.min(i, j) + 1;
                int max = Math.max(i, j) + 1;
                System.out.println(min + " " + max);
            } else {
                not_possible = true;
            }
        }

        if (not_possible) {
            System.out.println("-1 -1");
        }
        
        sc.close();
    }
}