package ru.geekbrains.oop.lesson4.task1;

public class MyArrayList<E> {

    private E[] array;
    private int lastIndex = -1;

    public MyArrayList(E[] array){
        this.array = array;
    }

    public int capacity(){
        return array.length;
    }

    public int size(){
        return lastIndex + 1;
    }

    public void add(E e){
        array[++lastIndex] = e;
    }

    public E get(int index){
        return array[index];
    }




}
