package ru.example;

public class Main {
    public static void main(String[] args) {
        /* Записать массив в файл */
        FileStream fileStream = new FileStream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        fileStream.writeToFile("array2.txt");
        /* Считать массив из файла */
        FileStream fileStream2 = new FileStream();
        fileStream2.readFromFile("array.txt");
        System.out.println(fileStream2);
        /* Замена символов в файле */
        FileStream.replaceSymbolInFile("1.txt", "2.txt", "o", "z");
    }
}