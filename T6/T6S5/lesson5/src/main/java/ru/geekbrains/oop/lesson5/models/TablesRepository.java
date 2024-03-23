package ru.geekbrains.oop.lesson5.models;

import ru.geekbrains.oop.lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 
 * Класс служит моделью данных в архитектурном паттерне MVC
 * (Model-View-Controller). Отвечает за управление данными о столиках и
 * операциями, связанными с бронированием.
 */
public class TablesRepository implements Model {

    private Collection<Table> tables; // Объекты, представляющие столики

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    // Бронирование столика
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    // Изменение данных о бронировании столика
    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        // Просматриваем все столики
        for (Table table : tables) {
            // Просматриваем все брони на столик
            for (Reservation reservation : table.getReservations()) {
                // Ищем нужную бронь
                if (reservation.getId() == oldReservation) {
                    // Удаляем старую бронь
                    table.getReservations().remove(reservation);
                    return reservationTable(reservationDate, tableNo, name);
                }
            }
        }
        // Если бронирование не найдено, выбрасываем исключение
        throw new RuntimeException("Некорректный идентификатор бронирования");
    }

}
