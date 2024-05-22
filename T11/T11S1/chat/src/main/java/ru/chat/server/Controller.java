package ru.chat.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Класс содержащий логику работы сервера
 * 
 * @repository абстракция базы данных логов
 * @clients абстракция базы данных клиентов
 * @ui абстракция графического интерфейса
 */
public class Controller {
    private static final String PATH_LOG = "log.txt";
    private static Random random = new Random();

    private Repository repository;
    private View ui;
    private boolean isServerRunned;
    private Clients clients;

    public Controller() {
        this.repository = new FileStorage(PATH_LOG);
        this.ui = new ServerGUI(this);
        this.clients = new Clients();
    }

    /** Запуск сервера */
    public void startServer() {
        isServerRunned = true;
        ui.showMessage(repository.read());
    }

    /** Остановка сервера */
    public void stopServer() {
        isServerRunned = false;
        clients.getClientsView().forEach(client -> client.disconnectedFromServer());
        clients.clear();
    }

    /** Отправка сообщения на сервер */
    public boolean sendMessage(String text, String token) {
        if (!clients.clientByTokenExist(token) || !isServerRunned || text.isEmpty())
            return false;

        String login = clients.getLoginByToken(token);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        String message = String.format("[%s] %s: %s\n", currentTime, login, text);

        ui.showMessage(message);
        clients.getClientsView().forEach(client -> client.showMessage(message));
        repository.save(message);

        return true;
    }

    /** Подключение к серверу */
    public String connectToServer(String ip, String port, String login, String password, ru.chat.client.View view) {
        String token = "";
        if (isServerRunned) {
            /* генерация уникального токена для клиента */
            do {
                token = "" + random.nextInt(Integer.MAX_VALUE);
            } while (clients.clientByTokenExist(token));

            clients.add(ip, port, login, password, token, view);
            view.showMessage(repository.read());
            ui.showMessage(login + " подключился к беседе\n");
        }
        return token;
    }

    /** Добавление клиентского окна */
    public void addClientWindow() {
        new ru.chat.client.Controller(this);
    }
}
