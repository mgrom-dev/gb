package ru.geekbrains.oop.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {

    public static void main(String[] args) {

        //int a = 1;

        Product product1 = new Product("Brand #1", " ", -1000 );
        Product product2 = new Product("Name #2", 350);


        product1.setPrice(-300);
        /*product1.name = "Name #1";
        product1.brand = "Brand #1";
        product1.price = -100;

        product2.name = null;
        product2.brand = "Brand #1";
        product2.price = 0;*/

        System.out.println(product1.displayInfo());
        System.out.println(product2.displayInfo());


        product1.setPrice(500);
        System.out.println(product1.displayInfo());

        BottleOfWater bottleOfWater1 = new BottleOfWater("Name #3", 250, 0.33);
        BottleOfMilk bottleOfMilk1 = new BottleOfMilk("Brand #1", "Name #2", 350, 0.5, 1);
        System.out.println(bottleOfWater1.displayInfo());
        System.out.println(bottleOfMilk1.displayInfo());

        Product product11 = new BottleOfWater("Name #3", 250, 0.5);
        Product product22 = new BottleOfMilk("Brand #1", "Name #2", 350, 0.5, 1);
        // чипсы
        Product lays = new Chips("Lays", "со сметаной", 250.00, 50);
        Product cheetos = new Chips("Cheetos", "с кетчупом", 220.00, 50);
        // шоколадки
        Product snigers = new Chocolate("Snigers", "с лесными орехами", 250.00, 200);
        Product twix = new Chocolate("Twix", "с карамелью", 280.00, 150);
        Product bounty = new Chocolate("Bounty", "маракуя", 300.00, 100);

        ArrayList<Product> list = new ArrayList<>();
        list.add(bottleOfWater1);
        list.add(bottleOfMilk1);
        list.add(product11);
        list.add(product22);
        list.addAll(Arrays.asList(lays, cheetos)); // добавляем чипсы
        list.addAll(Arrays.asList(snigers, twix, bounty)); // добавляем шоколадки

        VendingMachine vendingMachine = new VendingMachine(list);
        BottleOfWater bottleOfWaterRes = vendingMachine.getBottleOfWater("Name #3", 0.55);
        if (bottleOfWaterRes != null){
            System.out.println("Вы купили: ");
            System.out.println(bottleOfWaterRes.displayInfo());
        }
        else {
            System.out.println("Такой бутылки с водой нет в автомате.");
        }

        // делаем новые покупки
        Product buy1 = vendingMachine.getChips("Lays", 50);
        Product buy2 = vendingMachine.buyProduct("Snigers", 250);
        Product buy3 = vendingMachine.buyProduct("Bounty", 280);
        for (Product p : Arrays.asList(buy1, buy2, buy3)) {
            if (p != null) {
                System.out.println("Вы купили: ");
                System.out.println(p.displayInfo());
            } else {
                System.out.println("Недостаточно средств.");
            }
        }
    }

}
