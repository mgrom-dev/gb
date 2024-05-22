package ru.chat;

import ru.chat.server.Controller;

public class Main {
    public static void main(String[] args) {
        Controller serverWindow = new Controller();
        serverWindow.addClientWindow();
        //new ClientGUI(serverWindow);
        //new ClientGUI(serverWindow);
    }
}