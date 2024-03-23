package ru.geekbrains.oop.lesson5.views;

import ru.geekbrains.oop.lesson5.models.Table;
import ru.geekbrains.oop.lesson5.presenters.View;
import ru.geekbrains.oop.lesson5.presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Класс BookingView представляет собой представление (view) в архитектурном
 * паттерне MVC (Model-View-Controller)
 * Используется для отображения данных о столиках и результатов бронирования, а
 * также для уведомления зарегистрированных наблюдателей о событиях, таких как
 * бронирование и изменение статуса бронирования.
 */
public class BookingView implements View {

    private Collection<ViewObserver> observers; // Коллекция наблюдателей

    // Метод регистрации наблюдателя
    @Override
    public void registerObserver(ViewObserver observer) {
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(observer);
    }

    // Метод отображения информации о доступных столиках
    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    // Метод отображения результата бронирования столика
    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер брони: #%d\n", reservationNo);
        } else {
            System.out.println("Произошла ошибка при попытке забронировать столик.\nПовторите операцию позже.");
        }
    }

    // Метод для бронирования столика
    // Если есть зарегистрированные наблюдатели, уведомляем их о событии
    // бронирования столика
    public void reservationTable(Date orderDate, int tableNo, String name) {
        if (observers != null)
            for (ViewObserver observer : observers) {
                observer.onReservationTable(orderDate, tableNo, name);
            }
    }

    // паттерн проектировния Наблюдатель, используется для уведомления всех
    // зарегистрированных наблюдеталей о событии
    // событие изменение данных записи резервирования столика
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        if (observers != null)
            for (ViewObserver observer : observers) {
                observer.onchangeReservationTable(oldReservation, reservationDate, tableNo, name);
            }
    }

    // Метод отображения результата изменения данных о бронировании столика
    @Override
    public void showChangeReservationTableResult(int reservationNo, int tableNo, String name) {
        if (reservationNo > 0) {
            System.out.printf("Данные о бронировании столика успешно изменены. Номер брони: #%d, номер столика: %d, имя посетителя: %s\n",
                    reservationNo, tableNo, name);
        } else {
            System.out.println(
                    "Произошла ошибка при изменении данных о бронировании столика.\nПовторите операцию позже.");
        }
    }

}
