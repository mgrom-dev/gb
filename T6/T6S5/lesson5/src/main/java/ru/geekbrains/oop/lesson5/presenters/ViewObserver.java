package ru.geekbrains.oop.lesson5.presenters;

import java.util.Date;

/**
 * Интерфейс служит для определения контракта между классом, который
 * генерирует события бронирования столика, и классами, которые хотят
 * реагировать на эти события. Реализация этого интерфейса позволяет классу быть
 * наблюдателем за событиями бронирования столика и определять способы
 * реагирования на эти события.
 */
public interface ViewObserver {

    // резервирование столика
    void onReservationTable(Date orderDate, int tableNo, String name);

    // изменение данных записи резервирования столика
    void onchangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
