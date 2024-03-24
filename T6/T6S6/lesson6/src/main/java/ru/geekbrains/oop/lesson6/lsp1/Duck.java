package ru.geekbrains.oop.lesson6.lsp1;

/**
 * S
 */
public class Duck extends Bird{

    public Duck(){
        flySpeed = 30;
    }

    @Override
    public void fly() {
        System.out.printf("Утка летит со скоростью %d км/ч\n", flySpeed);
    }

}
