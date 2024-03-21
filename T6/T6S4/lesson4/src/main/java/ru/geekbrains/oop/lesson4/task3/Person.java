package ru.geekbrains.oop.lesson4.task3;

/**
 * Физ. лицо
 */
public class Person implements PersonalData {

    private String fio;
    private String inn;

    public Person(String fio, String inn) {
        this.fio = fio;
        this.inn = inn;
    }

    @Override
    public String getInn() {
        return inn;
    }

    public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return String.format("%s; %s", fio, inn);
    }

}
