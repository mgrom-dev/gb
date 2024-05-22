package ru.chat.client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ru.chat.server.ServerWindow;

@Deprecated
public class ClientGUI extends JFrame {
    /* настройки окна */
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String TITLE = "Chat client";

    private ServerWindow parent; // родительское окно
    private JPanel authPanel; // форма авторизации
    private JTextArea messageArea;
    private JTextField ipField;
    private JTextField portField;
    private JTextField loginField;
    private JTextField passField;
    private JTextField messageField;

    public ClientGUI(ServerWindow parent) {
        /* настройки окна */
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JPanel(){{setPreferredSize(new Dimension(0, 3));}}, BorderLayout.NORTH);
        contentPane.add(topPanel, BorderLayout.NORTH);
        this.parent = parent;

        /* форма авторизации */
        authPanel = new JPanel(new GridLayout(2, 3));
        ipField = new JTextField();
        portField = new JTextField();
        loginField = new JTextField();
        passField = new JPasswordField();
        authPanel.add(addField("IP:", "127.0.0.1", ipField));
        authPanel.add(addField("Port:", "8189", portField));
        authPanel.add(new JLabel(""));
        authPanel.add(addField("Login:", "Login...", loginField));
        authPanel.add(addField("Pass:", "", passField));
        JButton loginButton = new JButton("login");
        loginButton.addActionListener(this::loginConfirm);
        authPanel.add(loginButton);
        topPanel.add(authPanel, BorderLayout.SOUTH);

        // Область сообщений
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Панель ввода сообщения
        JPanel inputPanel = new JPanel(new BorderLayout());
        JButton sendButton = new JButton("send");
        sendButton.addActionListener(this::sendMessage);
        messageField = new JTextField();
        messageField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendButton.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent arg0) {}

            @Override
            public void keyTyped(KeyEvent arg0) { }
        });
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        contentPane.add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
        parent.addChildren(this);
    }

    /** Добавление текстового поля с подписью */
    private JPanel addField(String label, String text, JTextField textField) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel caption = new JLabel(label);
        caption.setBorder(new EmptyBorder(0, 5, 0, 5));
        panel.add(caption, BorderLayout.WEST);
        textField.setText(text);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    /** видимость панели авторизации */
    public void authPanelVisible(boolean visible) {
        authPanel.setVisible(visible);
    }

    /** получить область сообщений */
    public JTextArea getMessageArea() {
        return messageArea;
    }

    /** получить логин с формы */
    public String getLogin() {
        return loginField.getText();
    }

    /** авторизация пользователя */
    private void loginConfirm(ActionEvent e) {
        parent.loginUser(ipField.getText(), portField.getText(), loginField.getText(), passField.getText(), messageArea);
    }

    /** отправка сообщения */
    private void sendMessage(ActionEvent e) {
        parent.sendMessage(loginField.getText(), messageField.getText(), messageArea);
        messageField.setText("");
    }
}
