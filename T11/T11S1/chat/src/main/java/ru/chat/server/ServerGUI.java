package ru.chat.server;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Класс описывающий работу графического интерфейса сервера.
 * Является абстракцией GUI
 */
public class ServerGUI extends JFrame implements View {
    /* настройки окна */
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String TITLE = "Chat server";
    /* иконки окна */
    private static final String SERVER_STOPPED_ICO = "iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAACXBIWXMAAAsTAAALEwEAmpwYAAAFC0lEQVR4nO2aX0xbVRzHfzqz3oNhWVyyLEvMpi6wBzXRLSQzupmtyR6WbNEpmc7ExUSzmPkwHuTFROPDsoSp8cEnNUTD4gSMExacPXelVFiBOcZa6D8o9A9tb/lbCmyMtvzMQdreu7bA8F5a6P0m3/Dybc75fe7vnHu59wCoUqVKlSpVquTS5wCP6zRwhCdwgRL4mRKozYV5AjWUQBUlcKIWYDOsheiT8ALPQRdPAPPMrhsaOKxo8foi2EcJRPKg2IymBKKsGxQpvhmAowQGE4Ppt2rQ9slZ9Ff/gKHfanPiQM1P6KysQMOOrWIQk81FsEN2ALoi+DAxSPP2Ypyy3MV80eyQD1tLd4k74aLsAHgOriYGcF+6iPmm0O/1KQAc9MgOgHLQnRgg3GHCfNPc2Kh4GczIDoAn4EgMMON0YD5KvCGqAOQWvxE7QM/u6xx8TwnYKQfjS5knENswAGoBNlEClyiB+dU8cKx7AJSDb/7PE9e6BkA5OCC+8u3a13HgahP6rYMYcPqS9ljcaDM5kzaU7N4YAHgClxOhjqNaDAUjGBKm0uzzhNHeM5y0Ye9zywIYnbyHui43XutwYZ9/IutEbb4xvNbRj/wdN05Mz2bMPJiLYZvVjw3t/djpCGIsHpcHAOXAl3yi+8uQsfjVAIjG4njFYMNqnSXp4Ph0Ws47HJFk6ox2jM/Pp+UMZq8kxyDIA4BANBESPCOyAWBXXzxh5juuUFqOFfJwbnImvQt+bZHCZJ0gCwBeFMpW/GoAPIjG8LLeKpm0bySSlnMFw5IM65pYPL0D2PIQ525a/fkNgCk4No1/mPqw7m8HWgZHMJu6+kNYa7RjY0c/DodnMmZmZqMLEFgntFh8C4DzHkCupQIgagegugSIugegugkSRe4Ce1J3AYcdC24TNJbtT/5upKkRCw5A+3tnkr8zn3oTCw6A+Zc/JQM4Pz2P8fv3ccMCGPJNSgAwm94qlwyif4pg52tl2HVMmxNb3n8HZ4MBZQAIwSm094xIANhue7FVq131myQl3PdZpTIAQsIUDvaNpXWBzRzE219WoaH02ZwXz95sCXVXlAMQDETQ0SvtArF7aRferWnE7h/rZbG5uh5d9Q1Jtx85lJyrTgMXqAa0Ynce2P8S+yqmGICQMIV+3+SSEOS00yp9QfPPqdSeQzl4N1M9iHheUQChxU4YcI7lK4DNiDigKIBQYmMMRNDnDaN3cAI9CtjrnpCMd+uN46klwEF5tpoQ8YM1ARBaYxtLU6/iKQevLgFgEyL2bigA9m+/E1/RaXZCJWtR/0E4KTsAwR+WfCxZC3sMJjRXVOCN4idSADj4eqniFwE89sgABH84a/EDDdexefuWnN/reQLWJoAtywF4uLalQrOJ0K23T6LgG88IoPvcuVwXzq68SUdg50qKXzEASqBKHOw8fgwF72gaALe+DY17n4ku99lcbvMEvDwHjZSD0+xA5kqLX6zNvliXI2sIAdha+UoMwXT4IAZdQvoeEIz4YR3pOgdP0yL4iP1dNkwJfCGBcPAVDPQF1jWARxbPQaUYws2ylzFg9xQOACZK4GPxeYG2fS8unBUoGABMbN3wBOIJCK3Pl+BQt6NwADCxfzbEn86NJbvQ294tQCFJx0E5JTCXgNCye2esWQN7oJBECZwQPyxRDoYUOX2dz9IVwVFK4J4IwmkoNOk4OMQTsFECbbQYtuV6PqpUqVKlClanfwF6AQS3jle3bQAAAABJRU5ErkJggg==";
    private static final String SERVER_STARTED_ICO = "iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAACXBIWXMAAAsTAAALEwEAmpwYAAAE+ElEQVR4nO2aW2wUVRjHD2KwPadUgyYiiRQTfAAhYjReAtiIREhsUgORpBATYyIaHzTwUl6MPBkSxD4bjaKxCbTEVosN7Jnubou9bKvblt1u99budm+z0+t224XS3e1nZmW2M+yltM50t935J//sy39y5vvNN2dmzxyEVKlSpUqVKlWy6Sv0CNKQtxFDvkaU/IIorsuJGfwrouQiosWVqA5tQqsiSvYihhgRQyDPPIRayCFli9filxHF4TwoNr0piSa6QRHpUBGixCUM9ph2C3w6+AX84L8MddxvOfHPgVo4az8HT+i3iUDgaaTDW+UHoMEfC4Ns1j0N/TMmyBd553xQ9tcucSdckB8AQxqFAS64L0G+6RrXKAKAzfIDoKRPGKAzZIB80/j8hHg+iMgPgME2YQBbxAH5KMmEqAKQW8x67AAt/1wn3yOKrYjiyaxmcGz9AKhDGxHF3yBKFlbywrH2AVBc83/euNY2AFr0hvjKH+w6Cg1DN8Hic4Mt4Eva7BqBbpMj6e263esEAINrhdBbhgoIBsPABWdS7B0JgdU8mvQO/Z4lAYxP3wGN0Q3XDUPg8E9lPNFB7wRcNziB6XXD1Oxc2sy9+Ri0W/zwR5cTum0sxOJxmQBQ4hVCN1xtaYtfCYBoLA5X9IPwk8aUNDs5m5LzjIYlmfo2K8QXFlJy+tseSY6HIBeAqBDysGOyAeCvvviEefcOcSk5vpAHc9OR1C642iqFyXeCPACYxVCm4lcC4F40BrVai+SkvWPhlNwQG5Jk+K6JxVM7gL89xLkOiz+/AfBiJ2bh904H1N+ygck1BplkdHJQ12aFJoMTRkORtJnIXDQBge+EVpM3ATjvAeRaKgBG7QBQbwFGnQNAnQQZBZ4Cz+n2Jo+zRuxQcJPgvtaDyeOaxpqh4ABUdZxOHnfsdhUUHICrxpuSAc7Yq+Fu/C6sWwA+77QEAO/32j+QDFKsfQpe7S6Hw8aKnLjK9CEE5lhlAATZGbCaxyQA+sweKL9VseKVJCVc7fhSGQBccAZcjomULhgws3C+pwbK9C/kvHh+ZetK8JpyANhAGGwD0i4QW9vfC7XGZvjxnwZZfLm3AeqdfyZ9oOvIYkGaxF6Ew2K/0v3mSwDAKQaAC86A3zudFYKctlukCzTH/hbNOZScTFcOAJxRFAB3vxOG7RP5CmATAAwrCoATJsZAGLyeEHhcUzCigD3uKcl47/a8L74FTmQqCQA+WhUA3Cq7rG1xKR7RkgNZAGwEgIF1BaBm8DvxFZ1N7FDJIgA4LjuAABuSfCxZDevcBvi8/xw82vK4CAD+Nlvx9wFsWDaAABvKWHzjMIVS3dbcP+sZbEHNW0qXAvBgbdlCc0Kosuck+NjJtAA+6TubB8WTTqQp3vZQxT80AEouioNHu4+Dlx1PAdDi6oQdbbujS342l9sM8SCGNCFKTiU2ZC5H/Gf+/7rGljkEaANi8CUxhP2d78BwgEt97LFhP1pLulH0LKL4dOJ3SVFyXgzh9Y5D4PSzaxvAssXgajGEfe37wer3FBAAXrTkM/F+gT3tryX2ChQOAF78fcOQuADh+VsvQp/XXkAAePF/NkSfzre37YKukf4gKihpyAlEybwA4Rn9zhjSle5EBSVaXCl+WUKU+JTZfZ3P0uAjiJI7IginUMFJU1KOGDyIKG5HdPOTuT4dVapUqVKFVqZ/AZuICovovGj+AAAAAElFTkSuQmCC";

    /* элементы формы */
    private JTextArea messageArea;
    private JButton startButton;
    private JButton stopButton;
    
    private Controller controller;

    ServerGUI(Controller controller) {
        this.controller = controller;

        /* настройки окна */
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIcon(SERVER_STOPPED_ICO);
        
        /* элементы окна */
        messageArea = new JTextArea() {{ setEditable(false); }};
        startButton = new JButton("start") {{ addActionListener(e -> connect()); }};
        stopButton = new JButton("stop") {{ addActionListener(e -> disconnect()); }};
        stopButton.setEnabled(false);
        JPanel buttons = new JPanel(new GridLayout(1, 2)) {{ add(startButton); add(stopButton); }};

        add(new JScrollPane(messageArea));
        add(buttons, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void showMessage(String text) {
        messageArea.append(text);
    }

    @Override
    public void disconnect() {
        setIcon(SERVER_STOPPED_ICO);
        stopButton.setEnabled(false);
        startButton.setEnabled(true);
        messageArea.append("Сервер остановлен!\n");
        controller.stopServer();
    }

    @Override
    public void connect() {
        setIcon(SERVER_STARTED_ICO);
        stopButton.setEnabled(true);
        startButton.setEnabled(false);
        messageArea.setText("");
        controller.startServer();
        messageArea.append("Сервер запущен!\n");
    }
    
    /** установить иконку для окна */
    private void setIcon(String base64String) {
        try {
            byte[] imgBytes = Base64.getDecoder().decode(base64String);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgBytes));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
