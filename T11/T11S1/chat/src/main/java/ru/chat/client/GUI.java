package ru.chat.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
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
    /* иконки окна */
    private static final String CONNECTED_ICO = "/ru/chat/client/connected.png";
    private static final String DISCONNECTED_ICO = "/ru/chat/client/disconnected.png";

    /* позиционирование окон */
    private static enum Position {
        LEFT, RIGHT, TOP, BOTTOM
    };

    private static int position = 0;

    private JTextArea messageArea;
    private JPanel authForm;
    private Controller controller;

    public GUI(Controller controller) {
        this.controller = controller;

        /* настройки окна */
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        positionWindowAtBorders();

        /* верхняя панель формы */
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel bound3px = new JPanel() {
            {
                setPreferredSize(new Dimension(0, 3));
            }
        };
        topPanel.add(bound3px, BorderLayout.NORTH);
        authForm = createAuthForm();
        topPanel.add(authForm);

        /* средняя панель формы */
        messageArea = new JTextArea() {
            {
                setEditable(false);
            }
        };

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(messageArea), BorderLayout.CENTER);
        add(createInputForm(), BorderLayout.SOUTH);

        setIcon(DISCONNECTED_ICO);
        setVisible(true);
    }

    /** Добавление сообщения на форму */
    @Override
    public void showMessage(String message) {
        messageArea.append(message);
    }

    /** Позиционирование окна слева, справа, сверху, снизу */
    private void positionWindowAtBorders() {
        switch (Position.values()[position % 4]) {
            case LEFT -> setLocation(getX() - getWidth(), getY());
            case RIGHT -> setLocation(getX() + getWidth(), getY());
            case TOP -> setLocation(getX(), getY() - getHeight());
            default -> setLocation(getX(), getY() + getHeight());
        }
        position++;
    }

    @Override
    public void disconnectedFromServer() {
        messageArea.setText("");
        messageArea.append("Соединение с сервером потеряно!\n");
        setIcon(DISCONNECTED_ICO);
        authForm.setVisible(true);
    }

    /** Создание формы авторизации */
    private JPanel createAuthForm() {
        /* текстовые поля */
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
        loginButton.addActionListener(e -> {
            String ip = ipField.getText();
            String port = portField.getText();
            String login = loginField.getText();
            String pass = new String(passField.getPassword());
            boolean isConnect = controller.connectToServer(ip, port, login, pass);
            if (isConnect) {
                messageArea.append("Вы успешно подключились!\n");
                authPanel.setVisible(false);
                setIcon(CONNECTED_ICO);
                setTitle("Привет " + login);
            } else
                messageArea.append("Подключение не удалось!\n");
        });
        authPanel.add(loginButton);

        return authPanel;
    }

    /** Создание формы отправки сообщений */
    private JPanel createInputForm() {
        JPanel inputPanel = new JPanel(new BorderLayout());
        JTextField messageField = new JTextField();
        JButton sendButton = new JButton("send") {
            {
                addActionListener(e -> {
                    boolean isSend = controller.sendMessage(messageField.getText());
                    if (isSend)
                        messageField.setText("");
                    else
                        messageArea.append("Отправка сообщения не удалась!\n");
                });
            }
        };
        messageField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendButton.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        inputPanel.add(sendButton, BorderLayout.EAST);
        inputPanel.add(messageField);

        return inputPanel;
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

    /** Установить иконку для текущего окна */
    private void setIcon(String path) {
        try (InputStream resourceStream = this.getClass().getResourceAsStream(path)) {
            BufferedImage icon = ImageIO.read(resourceStream);
            setIconImage(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
