package ru.geekbrains.oop.lesson7.builder;

public class Program {

    public static void main(String[] args) {

        String s = new StringBuffer()
                .append("AAAAA")
                .append("BBBB")
                .toString();


        Order order = new OrderBuilder()
                .setSign(true)
                .setProductId(334411)
                .setPrice(200.5)
                .setQnt(4)
                .setProductName("Product #1")
                .build();

    }

}
