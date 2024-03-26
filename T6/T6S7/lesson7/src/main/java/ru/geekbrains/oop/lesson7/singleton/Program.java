package ru.geekbrains.oop.lesson7.singleton;

public class Program {

    public static void main(String[] args) {

        Settings settings1 = Settings.getInstance();
        Settings settings2 = Settings.getInstance();

        System.out.println(settings2.equals(settings1));


    }

}
