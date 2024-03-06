package ru.geekbrains.oop.lesson1;

import java.util.List;

public class VendingMachine {

    private List<Product> products;

    public VendingMachine(List<Product> products){
        this.products = products;
    }


    public BottleOfWater getBottleOfWater(String name, double volume){
        for (Product product : products){
            if (product instanceof BottleOfWater){
                BottleOfWater bottleOfWater = (BottleOfWater)product;
                if (bottleOfWater.getName().equals(name) && bottleOfWater.getVolume() == volume){
                    return bottleOfWater;
                }
            }
        }
        return null;
    }

    public Chips getChips(String brand, double weight){
        for (Product product : products){
            if (product instanceof Chips){
                Chips chips = (Chips)product;
                if (chips.getBrand() == brand && chips.getWeight() == weight){
                    return chips;
                }
            }
        }
        return null;
    }

    public Product buyProduct(String brand, double price){
        for (Product product : products){
            if (product.getBrand() == brand && product.getPrice() <= price){
                return product;
            }
        }
        return null;
    }

    public Chocolate getChocolate(String brand, double callories){
        for (Product product : products){
            if (product instanceof Chocolate){
                Chocolate chocolate = (Chocolate)product;
                if (chocolate.getBrand() == brand && chocolate.getCallories() == callories){
                    return chocolate;
                }
            }
        }
        return null;
    }

}
