package ru.chat.server;

/**
 * Интерфейс описывающий абстракцию GUI сервера
 */
public interface View {

    void showMessage(String text);

    void disconnect();

    void connect();
}
