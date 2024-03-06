package ru.geekbrains.oop.lesson1;

public class Chips extends Product {

    private int weight; // вес

    public Chips(String brand, String name, double price, int weight){
        super(brand, name, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String displayInfo() {
        return String.format("Чипсы:\n\t%s\n\t%s\n\t%.2f руб.\n\tВес: %d гр.",
                brand, name, price, weight);
    }

}
