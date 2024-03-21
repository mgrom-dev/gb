package ru.geekbrains.oop.lesson4.homework;
import java.util.ArrayList;

/**
 * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются
 * по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 */
public class Box<T extends Fruit> implements Comparable<Box<T>> {
    // c. Для хранения фруктов внутри коробки можно использовать ArrayList;
    private ArrayList<T> fruits;

    // g. Не забываем про метод добавления фрукта в коробку.
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    /**
     * d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес
     * одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы
     * измерения не важны);
     */
    public float getWeight() {
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    @Override
    public int compareTo(Box<T> o) {
        return Float.compare(getWeight(), o.getWeight());
    }

    /**
     * e. Внутри класса Box сделать метод compare(), который позволяет сравнить
     * текущую коробку с той, которую
     * подадут в compare() в качестве параметра. true – если их массы равны, false в
     * противоположном случае.
     * Можно сравнивать коробки с яблоками и апельсинами;
     */
    public boolean compare(Box<?> o) {
        return getWeight() == o.getWeight() ? true : false;
    }

    // ** f. Написать метод, который позволяет пересыпать фрукты из текущей коробки
    // в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с
    // апельсинами. Соответственно, в текущей коробке фруктов не остается, а в
    // другую перекидываются объекты, которые были в первой; */
    public void putsFruitsToAnotherBox(Box<? super T> o) {
        if (this == o) { // проверка если целевой объект, является текущим объектом
            return;
        }
        for (T fruit : fruits) {
            o.addFruit(fruit);
        }
        fruits.clear();
    }
}
