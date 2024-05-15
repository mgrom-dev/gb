package ru.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Создать массив из цифр и записать его в файл, используя поток вывода.
 * Считать массив цифр из файла, используя поток ввода.
 * Замена символа в текстовом файле на другой и запись в новый файл.
 */

public class FileStream {
    private int[] array;

    public FileStream(int[] array) {
        this.array = array;
    }

    public FileStream() {
        this.array = null;
    }

    /**
     * Запись массива целых чисел в файл
     * @param path - путь к файлу для записи
     */
    public void writeToFile(String path) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {
            for (int i = 0; i < array.length; i++) {
                dos.writeInt(array[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Чтение массива целых чисел из файла
     * @param path - путь к файлу для чтения
     * @return возвращает считанный массив целых чисел
     */
    public int[] readFromFile(String path) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            List<Integer> list = new ArrayList<>();
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
            array = list.stream().mapToInt(Integer::intValue).toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    /**
     * Замена символов в текстовом файле
     * @param srcPath - путь к исходному файлу, в котором нужно заменить символы
     * @param outPath - путь для записи измененных данных
     * @param oldChar - символ который нужно заменить
     * @param newChar - новый символ
     */
    public static void replaceSymbolInFile(String srcPath, String outPath, String replaceChar, String newChar) {
        String data = "";
        try (DataInputStream dis = new DataInputStream(new FileInputStream(srcPath))) {
            data = new String(dis.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        data = data.replaceAll(replaceChar, newChar);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(outPath))) {
            dos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}