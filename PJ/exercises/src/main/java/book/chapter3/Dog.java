package book.chapter3;

/**
 * Создайте класс Dog, содержащий два поля типа String: name и says. В методе
 * main() создайте два объекта Dog с разными именами (spot и scruffy) и
 * сообщениями. Выведите значения обоих полей для каждого из объектов.
 * 
 * Cоздайте новую ссылку на Dog и присвойте ее объекту spot. Сравните ссылки
 * оператором == и методом equals().
 */
public class Dog {
    String name;
    String says;

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.name = "spot";
        dog1.says = "afaff";
        Dog dog2 = new Dog();
        dog2.name = "scruffy";
        dog2.says = "rr-rr";
        System.out.printf("dog1 name: %s, says: %s\n", dog1.name, dog1.says);
        System.out.printf("dog2 name: %s, says: %s\n", dog2.name, dog2.says);
        Dog spot = new Dog();
        spot.name = new String("spot"); // выделяем новую область памяти под переменную String
        spot.says = "afaff"; // по умолчанию Java константы размещает в стеке, ссылка одна и та же
        System.out.printf("spot == dog1 {%s}, spot.equals(dog1) {%s}\n", spot == dog1, spot.equals(dog1));
        System.out.printf("spot.name == dog1.name {%s}, spot.name.equals(dog1.name) {%s}\n", spot.name == dog1.name,
                spot.name.equals(dog1.name));
        System.out.printf("spot.says == dog1.says {%s}, spot.says.equals(dog1.says) {%s}\n", spot.says == dog1.says,
                spot.says.equals(dog1.says));
    }
}
