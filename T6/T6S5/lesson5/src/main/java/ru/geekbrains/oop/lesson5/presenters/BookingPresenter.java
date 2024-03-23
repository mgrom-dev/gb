package ru.geekbrains.oop.lesson5.presenters;

import java.util.Date;

/**
 * Выполняет роль Presenter в архитектурном паттерне MVP
 * (Model-View-Presenter). Его задача - координировать взаимодействие между
 * моделью Model и представлением View. Является посредником между
 * пользовательским интерфейсом (представлением) и моделью данных
 */
public class BookingPresenter implements ViewObserver {

    private Model model; // Ссылка на объект модели данных
    private View view; // Ссылка на объект представления

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        // Регистрация текущего объекта презентера в качестве наблюдателя View
        this.view.registerObserver(this);
    }

    // Отображение информации о столиках с помощью метода showTables представления
    // View
    public void updateTablesView() {
        view.showTables(model.loadTables());
    }

    // Отображение результатов бронирования столика с помощью метода
    // showReservationTableResult представления View
    private void updateReservationTableView(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    // Отображение результатов изменения данных о бронировании столика с помощью
    // метода showReservationTableResult представления View
    private void updateChangeReservationTableView(int reservationNo, int tableNo, String name) {
        view.showChangeReservationTableResult(reservationNo, tableNo, name);
    }

    // Обработчик события бронирования столика
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        } catch (Exception e) {
            updateReservationTableView(-1);
        }
    }

    // Обработчик события изменения данных о бронировании столика
    @Override
    public void onchangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            // Вызов метода модели для изменения данных о бронировании столика
            int reservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            // Обновление View с результатом изменения данных о бронировании
            updateChangeReservationTableView(reservationNo, tableNo, name);
        } catch (Exception e) {
            updateChangeReservationTableView(-1, -1, "");
        }
    }
}
