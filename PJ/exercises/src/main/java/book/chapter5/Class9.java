package book.chapter5;

/**
 * Напишите метод, получающий список аргументов переменной длины с массивом
 * String. Убедитесь в том, что этому методу может передаваться как список
 * объектов String, разделенных запятыми, так и String[].
 * 
 * Напишите метод main (), использующий список аргументов переменной длины
 * вместо обычного синтаксиса. Выведите все элементы полученного массива args.
 * Протестируйте программу с разным количеством аргументов командной строки.
 */
public class Class9 {
    public static void testMethod(String... strings){
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String... args) {
        for (String string : args) {
            System.out.println(string);
        }
        testMethod("My life", "is gone");
        testMethod(new String[] {"World", "My"});
    }
}