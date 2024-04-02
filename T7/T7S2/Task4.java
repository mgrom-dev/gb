import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Исправьте код, примените
 * подходящие способы
 * обработки исключений
 */
public class Task4 {
    private static InputStream inputStream;

    public static void main(String[] args) {
        try {
            String[] strings = { "asdf", "txt" };
            String strings1 = strings[1];
            test();
            int a = 1 / 1; // деление на ноль приведет к ArithmeticException
            inputStream = new FileInputStream(a + "." + strings1); // создание объекта inputStream
            inputStream.close();
        } catch (StackOverflowError error) {
            System.out.println("Память превышена!");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка при выборе элемента массива");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("Я все равно выполнился!");
        }
        System.out.println("Я жив!");
    }

    public static void test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        try (FileReader reader = new FileReader(file)) {
            reader.read();
            reader.close();
            //test();
        }
    }
}
