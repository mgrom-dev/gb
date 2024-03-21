package ru.geekbrains.oop.lesson4.task1;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        MyArrayList<Employee> myArrayList1 = new MyArrayList<Employee>(new Employee[1000]);

       // myArrayList1.add(12);
        myArrayList1.add(new Employee("Name #1"));
        //myArrayList1.add("GeekBrains");
       // myArrayList1.add(-5);
        myArrayList1.add(new Employee("Name #2"));
        //myArrayList1.add(4);
       // myArrayList1.add(false);

        System.out.println("Кол-во элементов коллекции: " + myArrayList1.size());
        System.out.println("Значение элемента под индексом 2: " + myArrayList1.get(2));

        ArrayList<Employee> arrayList2 = new ArrayList<>();
        arrayList2.add(new Employee("Name #1"));
        //arrayList2.add("GeekBrains");
        //arrayList2.add(-5);
        arrayList2.add(new Employee("Name #2"));
        //arrayList2.add(4);
       //arrayList2.add(false);

        for (Employee o : arrayList2){
            System.out.println(o.getName());

        }

    }

}
