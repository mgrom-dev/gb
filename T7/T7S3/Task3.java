import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 1. Создайте класс исключения, который будет выбрасываться при делении на
 * 0. Исключение должно отображать понятное для пользователя сообщение
 * об ошибке.
 * 2. Создайте класс исключений, которое будет возникать при обращении к
 * пустому элементу в массиве ссылочного типа. Исключение должно
 * отображать понятное для пользователя сообщение об ошибке.
 * 3. Создайте класс исключения, которое будет возникать при попытке открыть
 * несуществующий файл. Исключение должно отображать понятное для
 * пользователя сообщение об ошибке.
 */

class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException() {
        super("\nДелить на 0, целые числа нельзя!");
    }
}

class IndexEmptyException extends NullPointerException {
    public IndexEmptyException() {
        super("\nПустой элемент массива!");
    }
}

class FileNotFoundException extends RuntimeException {
    public FileNotFoundException() {
        super("\nФайл не найден!");
    }
}

public class Task3 {
    public static void main(String[] args) {
        try {
            //int x = 2 / 0;
            //System.out.println(x);
            // Integer[] arr = {9, 2, 3, null, 5, 7};
            // for(Integer i : arr) {
            //     if (i == null) {
            //         throw new IndexEmptyException();
            //     }
            //     System.out.println(i);
            // }
            Files.newBufferedReader(Path.of("3.txt")).readLine();
        } catch (ArithmeticException ex) {
            throw new DivisionByZeroException();
        } catch (IOException ex) {
            throw new FileNotFoundException();
        }
    }
}
