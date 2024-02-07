/* Задачи: №1, №2 
1. Получаем значения натуральной степени k для первого и второго многочлена из консоли.
2. Формируем список коэффициентов многочлена, пробегаясь по степеням от 0 до k и добавляя случайное число в массив.
3. Формируем многочлен вида: 2x^2 + 4x + 5.
4. Записываем полученный многочлен в файл и повторяем пункты 1, 2, 3, 4 для второго многочлена.
5. Суммируем многочлены из файлов и записываем результат в 3 файл, выводим результат.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class App {
    final static String PATH1 = "polynomial1.txt",
            PATH2 = "polynomial2.txt",
            RESULT_PATH = "result.txt";
    final static int MAX_FACTOR_VALUE = 100;
    final static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {

        int k1 = readInt("Введите степень k 'первого многочлена', от 1 до 9: ");
        int k2 = readInt("Введите степень k 'второго многочлена', от 1 до 9: ");
        int[] ka1 = generateRandomArray(k1 + 1);
        int[] ka2 = generateRandomArray(k2 + 1);
        writeToFile(createPolynomial(ka1), PATH1);
        writeToFile(createPolynomial(ka2), PATH2);
        String polynom1 = readFile(PATH1);
        String polynom2 = readFile(PATH2);
        String sumPolynoms = sumPolynoms(polynom1, polynom2);
        writeToFile(sumPolynoms, RESULT_PATH);
        System.out.println(sumPolynoms);
    }

    // Считывание целого числа из консоли
    static int readInt(String message) {
        int result = 0;
        while (result <= 0) {
            try {
                System.out.print(message);
                String s = SCAN.next("[0-9]");
                result = Integer.parseInt(s);
            } catch (InputMismatchException e) {
                SCAN.nextLine(); // Очистить буфер ввода
            }
        }
        return result;
    }

    // создание массива заданной длины, заполненного случайными значениями
    static int[] generateRandomArray(int size) {
        int[] result = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++)
            result[i] = random.nextInt(MAX_FACTOR_VALUE + 1);
        return result;
    }

    // создание многочлена в виде строки, из массива целых чисел
    static String createPolynomial(int[] coefficients) {
        StringBuilder polynomial = new StringBuilder();
        for (int i = 0, k = coefficients.length; i < coefficients.length; i++, k--) {
            if (coefficients[i] > 0) {
                if (i > 0)
                    polynomial.append(" + ");
                if (k > 1) {
                    polynomial.append(coefficients[i] == 1 ? "x" : coefficients[i] + "x");
                    polynomial.append(k < 3 ? "" : "^" + (k - 1));
                } else
                    polynomial.append(coefficients[i]);
            }
        }
        polynomial.append(" = 0");
        return polynomial.toString();
    }

    // запись данных в файл
    static void writeToFile(String data, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    // чтение данных из файла
    static String readFile(String path) {
        StringBuilder result = new StringBuilder();
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                result.append(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
        return result.toString();
    }

    // сложение 2ух многочленов
    static String sumPolynoms(String polynom1, String polynom2) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> keys = new ArrayList<String>();
        for (String polynom : new String[] { polynom1, polynom2 }) {
            String[] members = polynom.split(" ?[+=] ?");
            members = Arrays.copyOf(members, members.length - 1);
            for (String member : members) {
                String key = "0";
                int value;
                int indexX = member.indexOf("x");
                if (indexX != -1) {
                    key = member.substring(indexX, member.length());
                    value = Integer.parseInt(member.substring(0, indexX));
                } else
                    value = Integer.parseInt(member);
                if (map.containsKey(key))
                    map.put(key, map.get(key) + value);
                else{
                    map.put(key, value);
                    keys.add(key);
                }
            }
        }
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if (i > 0)
                result.append(" + ");
            result.append(map.get(key) + (key != "0" ? key : ""));
        }
        result.append(" = 0");
        return result.toString();
    }
}
