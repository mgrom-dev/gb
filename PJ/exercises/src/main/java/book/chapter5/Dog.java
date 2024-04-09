package book.chapter5;

/**
 * Создайте класс Dog (собака) с перегруженным методом bark() (лай). Метод
 * должен быть перегружен для разных примитивных типов данных с целью вывода
 * сообщения о лае, завывании, поскуливании и т. п. в зависимости от версии
 * перегруженного метода. Напишите метод main(), вызывающий все версии
 * Измените предыдущее упражнение так, чтобы два перегруженных метода принимали
 * два аргумента (разных типов) и отличались только порядком их следования в
 * списке аргументов. Проверьте, работает ли это.
 */
public class Dog {

    static class DogClass {
        void bark(int volume) {
            System.out.println("Dog bark with volume: " + volume);
        }

        void bark(char sound) {
            System.out.println("Dog bark with sound: " + sound + sound + sound);
        }

        void bark(float min) {
            System.out.println("Dog bark time: " + min + " min.");
        }

        void bark(char sound, int count) {
            for (int i = 0; i < count; i++)
                System.out.println("Dog bark with sound: " + sound);
        }

        void bark(int volume, char sound) {
            System.out.println("Dog bark with sound: " + sound + ", and volume: " + volume);
        }
    }

    public static void main(String[] args) {
        DogClass dog = new DogClass();
        dog.bark(0.1f);
        dog.bark('A');
        dog.bark(5);
        dog.bark('O', 5);
        dog.bark(10, 'R');
    }
}
