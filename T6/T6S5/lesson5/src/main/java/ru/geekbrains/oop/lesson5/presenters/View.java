package ru.geekbrains.oop.lesson5.presenters;

import ru.geekbrains.oop.lesson5.models.Table;

import java.util.Collection;

/**
 * Реализация этого интерфейса в классах представления позволяет презентеру
 * обновлять пользовательский интерфейс согласно результатам операций, таких как
 * бронирование столика или изменение бронирования, а также для регистрации
 * наблюдателей, которые могут реагировать на события в представлении.
 */
public interface View {

    void showTables(Collection<Table> tables);

    void showReservationTableResult(int reservationNo);

    void showChangeReservationTableResult(int reservationNo, int tableNo, String name);

    void registerObserver(ViewObserver observer);
}
