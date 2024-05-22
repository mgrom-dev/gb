package ru.chat.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Класс описывающий работу графического интерфейса клиента.
 * Является абстракцией GUI
 */
public class GUI extends JFrame implements View {
    /* настройки окна */
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String TITLE = "Chat client";

    /* позиционирование окон */
    private static enum Position { BOTTOM, LEFT, RIGHT, TOP };
    private static int position = 0;

    private JTextArea messageArea;
    private JPanel authForm;

    public GUI() {
        /* настройки окна */
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);

        /* верхняя панель формы */
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel bound3px = new JPanel() {{ setPreferredSize(new Dimension(0, 3)); }};
        topPanel.add(bound3px, BorderLayout.NORTH);
        authForm = createAuthForm();
        topPanel.add(authForm);

        messageArea = new JTextArea() {{ setEditable(false); }};

        /* нижняя панель формы */
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JButton("send"), BorderLayout.EAST);
        inputPanel.add(new JTextField());

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(messageArea), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void showMessage(String message) {
        messageArea.append(message);
    }

    @Override
    public void disconnectedFromServer() {
        messageArea.append("Соединение с сервером потеряно!");
    }

    /** Создание формы авторизации */
    private JPanel createAuthForm() {
        /* форма авторизации */
        JPanel authPanel = new JPanel(new GridLayout(2, 3));
        JTextField ipField = new JTextField();
        JTextField portField = new JTextField();
        JTextField loginField = new JTextField();
        JPasswordField passField = new JPasswordField();
        
        authPanel.add(addField("IP:", "127.0.0.1", ipField));
        authPanel.add(addField("Port:", "8189", portField));
        authPanel.add(new JLabel(""));
        authPanel.add(addField("Login:", "Login...", loginField));
        authPanel.add(addField("Pass:", "", passField));
        JButton loginButton = new JButton("login");
        //loginButton.addActionListener(e -> controller.connectToServer(TITLE, TITLE));
        authPanel.add(loginButton);

        return authPanel;
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
}
