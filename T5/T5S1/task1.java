import java.time.LocalTime;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя пользователя: ");
        String name = scan.next();
        LocalTime time = LocalTime.now();
        if (time.isAfter(LocalTime.of(4, 59)) && time.isBefore(LocalTime.of(12, 0)))
            System.out.printf("Доброе утро, %s", name);
        else if (time.isAfter(LocalTime.of(11, 59)) && time.isBefore(LocalTime.of(18, 0))) 
            System.out.printf("Добрый день, %s", name);
        else if (time.isAfter(LocalTime.of(17, 59)) && time.isBefore(LocalTime.of(23, 0)))
            System.out.printf("Добрый вечер, %s", name);
        else
            System.out.printf("Доброй ночи, %s", name);
        scan.close();
    }
}
