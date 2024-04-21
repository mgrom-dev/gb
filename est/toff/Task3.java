import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int time = scan.nextInt();
        int[] floors = new int[count];
        int min = 0, max = 0;
        for (int i = 0; i < count; i++){
            int floor = scan.nextInt();
            floors[i] = floor;
            if (floor > max) max = floor;
            if (floor < min || min == 0) min = floor;
        }
        int employee = scan.nextInt();
        scan.close();

        // поднимаемся с первого этажа
        int timeRes1 = 0;
        for (int i = 1; i < employee && timeRes1 < time; i++)
            timeRes1 += floors[i] - floors[i - 1];
        // спускаемся с последнего этажа
        int timeRes2 = 0;
        for (int i = count - 1; i >= employee && timeRes2 < time; i--)
            timeRes2 += floors[i] - floors[i - 1];
        
        if (timeRes1 <= time || timeRes2 <= time) System.out.println(max - min);
        else {
            int time1 = max - min + max - floors[employee - 1];
            int time2 = max - min + floors[employee - 1] - min;
            System.out.print(time1 > time2 ? time2 : time1);
        }
    }
}