package ru.chat;

import ru.chat.client.ClientGUI;
import ru.chat.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = ServerWindow.getInstance();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}