import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long min = scan.nextLong();
        long max = scan.nextLong();
        scan.close();

        int count = 0;
        String numStr = min + "";
        int k = numStr.length();
        long num = min;
        int i = numStr.charAt(0) - '0';
        while (num <= max) {
            try {
                num = Long.parseLong(((i % 10) + "").repeat(k));
            } catch (Exception e) {
                break;
            }
            if (num > max) break;
            count++;
            i++;
            if (i % 10 == 0) {
                k++;
                i++;
            }
        }
        
        System.out.println(count);
    }

}