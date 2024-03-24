package ru.geekbrains.oop.lesson6.lsp1;

/**
 * T
 */
public class Bird {

    protected int flySpeed = 25;

    private boolean canFly;

    public Bird(){
        canFly = true;
    }

    public Bird(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public int getFlySpeed() {
        return flySpeed;
    }

    public void fly() {
        System.out.printf("Птица летит со скоростью %d км/ч\n", flySpeed);
    }


}
