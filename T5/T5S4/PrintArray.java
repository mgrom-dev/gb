import java.util.LinkedList;
import java.util.Scanner;

/**
 * Реализовать консольное приложение, которое:
 * 1. Принимает от пользователя и “запоминает” строки.
 * 2. Если введено print, выводит строки так, чтобы последняя введенная
 * была первой в списке, а первая - последней.
 * 3. Если введено revert, удаляет предыдущую введенную строку из памяти.
 */
public class PrintArray {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        String str = "";
        System.out.println("Введите любую строку, чтобы записать ее в память");
        System.out.println("Введите print, чтобы вывести строки в памяти");
        System.out.println("Введите revert, чтобы удалить последнюю строку из памяти");
        System.out.println("Введите Q для выхода");
        while (!(str = scan.nextLine()).toLowerCase().trim().equals("q")) {
            if (str.toLowerCase().trim().equals("print"))
                for (int index = list.size() - 1; index >= 0; index--)
                    System.out.print(list.get(index) + " ");
            else if (str.toLowerCase().trim().equals("revert"))
                list.removeLast();
            else
                list.add(str);
        }
        scan.close();
    }
}
