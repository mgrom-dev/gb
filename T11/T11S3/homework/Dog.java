package homework;

public class Dog extends Animal{

    private String name;

    public Dog() {
        this("dog");
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println("hav hav");
    }

    @Override
    public String toString() {
        return "this is dog by name: " + name;
    }
}
