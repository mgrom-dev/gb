package ru.geekbrains.oop.lesson5.presenters;

import ru.geekbrains.oop.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

/**
 * Интерфейс Model определяет контракт для модели в архитектурном паттерне MVC,
 * определяя методы, которые должны быть реализованы классом, представляющим
 * модель данных.
 * Он обеспечивает стандартизированный способ взаимодействия между
 * представлением (view) и моделью данных, позволяя представлению получать
 * данные о столиках и выполнять операции бронирования и изменения бронирования.
 */
public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
