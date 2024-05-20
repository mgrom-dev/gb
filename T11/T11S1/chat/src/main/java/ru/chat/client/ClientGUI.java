package ru.chat.client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ru.chat.server.ServerWindow;

public class ClientGUI extends JFrame {
    /* настройки окна */
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String TITLE = "Chat client";

    private JPanel authPanel;
    private JTextArea messageArea;

    public ClientGUI(ServerWindow parent) {
        /* настройки окна */
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        authPanel = new JPanel(new GridLayout(2, 3));
        authPanel.add(addTextField("IP:", "127.0.0.1"));
        authPanel.add(addTextField("Port:", "8189"));
        authPanel.add(new JLabel(""));
        authPanel.add(addTextField("Login:", "Login..."));
        authPanel.add(addTextField("Password:", ""));
        authPanel.add(new JButton("Login"));

        // // Панель авторизации
        // authPanel = new JPanel(new GridLayout(2, 1, 0, -5));

        // // Строка с IP и портом
        // JPanel ipPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // JTextField ipField = new JTextField("127.0.0.1", 10);
        // JTextField portField = new JTextField("8189", 4);
        // ipPanel.add(new JLabel("IP:"));
        // ipPanel.add(ipField);
        // ipPanel.add(new JLabel("Port:"));
        // ipPanel.add(portField);
        // authPanel.add(ipPanel);

        // // Строка с логином, паролем и кнопкой
        // JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // JTextField loginField = new JTextField("Login...", 8);
        // JPasswordField passwordField = new JPasswordField(8);
        // JButton loginButton = new JButton("Login");
        // loginPanel.add(new JLabel("Login:"));
        // loginPanel.add(loginField);
        // loginPanel.add(new JLabel("Password:"));
        // loginPanel.add(passwordField);
        // loginPanel.add(loginButton);
        // authPanel.add(loginPanel);

        // Область сообщений
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        // Панель ввода сообщения
        JPanel inputPanel = new JPanel(new BorderLayout());
        JTextField messageField = new JTextField();
        JButton sendButton = new JButton("Send");
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Компоновка элементов на форме
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(authPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);

        parent.addChildren(this);
    }

    /**
     * Добавление текстового поля с представлением
     * 
     * @param caption - краткое описание текстового поля
     * @param text    - текст внутри поля
     * @return
     */
    private JPanel addTextField(String caption, String text) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(caption);
        label.setBorder(new EmptyBorder(0, 5, 0, 5));
        panel.add(label, BorderLayout.WEST);
        panel.add(new JTextField(text), BorderLayout.CENTER);
        return panel;
    }

    /** видимость панели авторизации */
    public void authPanelVisible(boolean visible) {
        authPanel.setVisible(visible);
    }
}
