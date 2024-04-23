package book.chapter7;

/**
 * Создайте простой класс. Во втором классе определите ссылку на объект первого
 * класса. Используйте отложенную инициализацию для создания экземпляров этого
 * класса.
 */
public class Class1 {
    private static testClass1 obj = new testClass1();
    public static void main(String[] args) {
        System.out.println(obj.message);
        obj.message = "new string";
        System.out.println(obj.message);
    }
}

class testClass1 {
    String message;
}