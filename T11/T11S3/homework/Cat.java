package homework;

public class Cat extends Animal {
    private String name;

    public Cat() {
        this("cat");
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println("meow");
    }
    
    @Override
    public String toString() {
        return "this is cat by name: " + name;
    }
}
