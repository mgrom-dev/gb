package book.chapter5;

/**
 * Создайте класс, производный от String, инициализируемый в секции
 * инициализации экземпляров.
 * 
 * Создайте массив объектов String. Присвойте объект String каждому элементу.
 * Выведите содержимое массива в цикле for.
 * 
 * Создайте класс с конструктором, получающим аргумент String. Выведите
 * значение аргумента во время конструирования. Создайте массив ссылок на этот
 * класс, но не создавайте объекты, которыми заполняется массив. Запустите
 * программу и посмотрите, будут ли выводиться сообщения при вызове
 * конструкторов.
 * 
 * Завершите предыдущее упражнение — создайте объекты, которыми
 * заполняется массив ссылок.
 */
public class MyString {
    String str = " inherit ";
    {
        str += " init ";
    }

    MyString(String str) {
        System.out.println("in constructor: " + str);
        this.str += " " + str + " ";
    }

    public static void main(String[] args) {
        String[] strings = {"str1", "str2", "str3"};
        for (String string : strings) {
            System.out.println(string);
        }

        MyString[] myStrings = new MyString[3];
        myStrings[0] = new MyString("Hello");
        myStrings[1] = new MyString("World");
        myStrings[2] = new MyString("!");
        for (MyString string : myStrings) {
            System.out.println(string);
        }

        System.out.println(new MyString("hello"));
    }

    @Override
    public String toString() {
        return str;
    }
}
