package ru.geekbrains.oop.lesson6.ocp1;

import java.util.List;

public class AreaService {

    public static double calcArea(List<Shape> list){
        double sumArea = 0;
        for (Shape shape : list) {
            sumArea += shape.getArea();
            /*if (shape instanceof RightTriangle) {
                RightTriangle triangle = (RightTriangle) shape;
                sumArea += triangle.getKatet1() * triangle.getKatet2() / 2.0;
            } else if (shape instanceof Square) {
                Square square = (Square) shape;
                sumArea += Math.pow(square.getSide(), 2);
            } else if (shape instanceof Circle){
                Circle circle = (Circle) shape;
                sumArea += Math.PI * circle.getRadius() * circle.getRadius();
            }*/
        }
        return sumArea;
    }

}
