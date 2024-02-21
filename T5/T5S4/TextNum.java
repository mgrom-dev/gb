import java.util.Arrays;
import java.util.LinkedList;

/**
 * Реализовать консольное приложение, которое:
 * 1. Принимает от пользователя строку вида
 * text~num
 * 2. Нужно рассплитить строку по ~, сохранить text в связный список на
 * позицию num.
 * 3. Если введено print~num, выводит строку из позиции num в связном
 * списке и удаляет её из списка.
 */
public class TextNum {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.println(Arrays.toString(args));
        for (String param : args) {
            String[] params = param.split("~");
            if (params.length == 2) {
                int index = Integer.parseInt(params[1]);
                if (params[0].equals("print"))
                    System.out.println(list.remove(index > list.size() ? list.size() : index));
                else
                    list.add(index > list.size() ? list.size() : index, params[0]);
            }
        }
    }
}
