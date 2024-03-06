package ru.geekbrains.oop.lesson1;

public class Chocolate extends Product {

    private int callories; // калории

    public Chocolate(String brand, String name, double price, int callories){
        super(brand, name, price);
        this.callories = callories;
    }

    public double getCallories() {
        return callories;
    }

    public void setCallories(int callories) {
        this.callories = callories;
    }

    @Override
    public String displayInfo() {
        return String.format("Шоколад:\n\t%s\n\t%s\n\t%.2f руб.\n\tКалории: %d",
                brand, name, price, callories);
    }

}
