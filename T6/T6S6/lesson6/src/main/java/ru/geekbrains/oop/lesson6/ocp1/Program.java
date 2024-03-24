package ru.geekbrains.oop.lesson6.ocp1;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new RightTriangle(2, 3));
        shapes.add(new Square(4));
        shapes.add(new Circle(3));
        System.out.printf("Сумма площадей фигур равна %f \n", AreaService.calcArea(shapes));


    }

}
