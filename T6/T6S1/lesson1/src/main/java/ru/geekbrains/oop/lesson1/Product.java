package ru.geekbrains.oop.lesson1;

/**
 * Продукт
 */
public class Product {

    //region Публичные методы

    public String displayInfo(){
        return String.format("%s - %s - %.2f", brand, name, price);
    }

    //endregion

    //region Конструкторы

    public Product(String brand, String name, double price){
        checkBrand(brand);
        checkName(name);
        checkPrice(price);
    }

    public Product(String name, double price){
        this("<BRAND>", name, price);
        /*brand = "<BRAND>";
        if (inputName == null || inputName.length() < 3){
            name = "<NAME>";
        }
        else {
            name = inputName;
        }
        if (inputPrice < 200){
            price = 200;
        }
        else {
            price = inputPrice;
        }*/
    }

    public Product(String name){
        this(name, 200);
        /*brand = "<BRAND>";
        price = 200;
        if (inputName == null || inputName.length() < 3){
            name = "<NAME>";
        }
        else {
            name = inputName;
        }*/
    }

    /*public Product(){
        this("<NAME>");
        brand = "<BRAND>";
        name = "<NAME>";
        price = 200;
    }*/

    //endregion

    //region Вспомогательные методы (доступны на уровне класса)

    private void checkBrand(String brand){
        if (brand == null || brand.length() < 3){
            this.brand = "<BRAND>";
        }
        else {
            this.brand = brand;
        }
    }

    private void checkName(String name){
        if (name == null || name.length() < 3){
            this.name = "<NAME>";
        }
        else {
            this.name = name;
        }
    }

    private void checkPrice(double price){
        if (price < 200){
            this.price = 200;
        }
        else {
            this.price = price;
        }
    }

    //endregion

    //region Свойства полей (getters and setters)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkName(name);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        checkBrand(brand);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        checkPrice(price);
    }

    //endregion

    //region Поля

    protected String name;
    protected String brand;
    protected double price;

    //endregion

}
