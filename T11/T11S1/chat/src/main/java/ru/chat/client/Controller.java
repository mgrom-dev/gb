package ru.chat.client;

/**
 * Класс содержащий логику работы клиента
 */
public class Controller {
    private View ui;
    private ru.chat.server.Controller server;
    private String token;

    public Controller(ru.chat.server.Controller server) {
        this.ui = new GUI(this);
        this.server = server;
    }

    /** Авторизация на сервере */
    public boolean connectToServer(String ip, String port, String login, String password) {
        token = server.connectToServer(ip, port, login, password, ui);
        return !token.isEmpty();
    }

    /** Отправка сообщения на сервер */
    public boolean sendMessage(String message) {
        return server.sendMessage(message, token);
    }
}
