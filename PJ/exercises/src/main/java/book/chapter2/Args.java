package book.chapter2;

/**
 * Напишите программу, которая выводит три параметра командной строки. Для
 * получения аргументов вам потребуется обращение к элементам массива строк
 * (String).
 */
public class Args {
    public static void main(String[] args) {
        if (args.length == 3)
            System.out.printf("%s\n%s\n%s\n", args[0], args[1], args[2]);
        else
            System.out.println("give me please three start args");
    }
}
