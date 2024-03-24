package ru.geekbrains.oop.lesson6.srp2;

import java.util.Scanner;

// ����� ���������� �� ���� ������ ������ � �������.
public class OrderInputer {
    private static Scanner scanner = new Scanner(System.in);

    // ���� ������ ������ ����� �������
    public static Order inputOrderFromConsole() {
        String name = prompt("��� �������: ");
        String product = prompt("�������: ");
        int qnt = Integer.parseInt(prompt("���-��: "));
        int price = Integer.parseInt(prompt("����: "));
        return new Order(name, product, qnt, price);
    }

    private static String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
