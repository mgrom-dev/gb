package ru.geekbrains.oop.lesson4.task2;

import java.util.List;

public interface Repository<E> {

    void add(E item);
    void update(E item);
    void delete(int id);

    E getById(int id);

    List<E> getAll();

}
