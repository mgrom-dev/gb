package ru.chat.server;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.chat.client.View;

/**
 * Абстракция базы данных клиентов
 */
public class Clients {
    private List<Client> clients;

    @Data
    @AllArgsConstructor
    private static class Client {
        private String ip;
        private String port;
        private String login;
        private String password;
        private String token;
        private View view;
    }

    public Clients() {
        clients = new ArrayList<>();
    }

    /** Добавление клиента */
    public void add(String ip, String port, String login, String password, String token, View view) {
        clients.add(new Client(ip, port, login, password, token, view));
    }

    /** Очистка всех клиентов */
    public void clear() {
        clients.clear();
    }

    /** Проверить существует ли клиент по логину */
    public boolean clientByLoginExist(String login) {
        for (Client client : clients) {
            if (client.getLogin().equals(login)) return true;
        }
        return false;
    }

    /** Проверить существует ли клиент по токену */
    public boolean clientByTokenExist(String token) {
        for (Client client : clients) {
            if (client.getToken().equals(token)) return true;
        }
        return false;
    }

    /** Получить логин клиента по токену */
    public String getLoginByToken(String token) {
        for (Client client : clients) {
            if (client.getToken().equals(token)) return client.login;
        }
        return null;
    }

    /** Получить интерфейсы клиентов */
    public List<View> getClientsView() {
        List<View> views = new ArrayList<>();
        clients.forEach(client -> views.add(client.getView()));
        return views;
    }
}
