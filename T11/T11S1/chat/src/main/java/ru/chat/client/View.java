package ru.chat.client;

/**
 * Интерфейс описывающий абстракцию GUI клиента
 */
public interface View {
    /**
     * Метод для отображения сообщения в GUI
     * @param message текст сообщения
     */
    void showMessage(String message);

    /**
     * Метод отключения от сервера со стороны сервера
     */
    void disconnectedFromServer();
}
