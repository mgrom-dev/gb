/**
 * 1. Реализуйте 1 из вариантов класса Cat из предыдущего задания, можно
 * использовать не все придуманные поля и методы. Создайте несколько
 * экземпляров этого класса, выведите их в консоль.
 * 2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat, выводилась
 * его кличка, цвет и возраст (или другие параметры на ваше усмотрение).
 */
public class Cat {
    private String name;
    private String color;
    private int age;

    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik", "black", 2);
        Cat baton = new Cat("Baton", "orange", 3);
        Cat rex = new Cat("Rex", "yellow", 1);
        System.out.println(barsik);
        System.out.println(baton);
        System.out.println(rex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Кот [имя=" + name + ", цвет=" + color + ", возраст=" + age + "]";
    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

}
