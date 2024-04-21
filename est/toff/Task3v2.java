import java.util.Scanner;

public class Task3v2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lineNumbers = scan.nextLine().split(" ");
        int count = Integer.parseInt(lineNumbers[0]);
        int time = Integer.parseInt(lineNumbers[1]);

        lineNumbers = scan.nextLine().split(" ");
        int min = Integer.parseInt(lineNumbers[0]);
        int max = Integer.parseInt(lineNumbers[lineNumbers.length - 1]);

        int employeeOut = Integer.parseInt(lineNumbers[scan.nextInt() - 1]);
        scan.close();
        if (count <= 0) return;

        if (employeeOut - min <= time || max - employeeOut <= time)
            System.out.println(max - min);
        else {
            int time1 = max - min + max - employeeOut;
            int time2 = max - min + employeeOut - min;
            System.out.print(time1 > time2 ? time2 : time1);
        }
    }
}