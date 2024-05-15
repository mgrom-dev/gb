package ru.homework;

public enum ANSI {
    WHITE("\u001B[47m"), RED("\u001B[41m"), GREEN("\u001B[42m"), YELLOW("\u001B[43m"), RESET("\u001B[0m");
    String color;

    ANSI(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
