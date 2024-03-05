package ru.geekbrains.oop.lesson1;

public class BottleOfWater extends Product {

    private double volume; // объем

    public BottleOfWater(String name, double price, double volume){
        super(name, price);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String displayInfo() {
        return String.format("Бутылка с водой:\n\t%s\n\t%s\n\t%.2f\n\tОбъем: %.2f",
                brand, name, price, volume);
    }

}
