import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;

    private int currentFieldSize = 3;
    private int currentWinLength = 3;

    private JButton btnStart;

    SettingWindow(GameWindow gameWindow){
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(gameModePanel());
        panel.add(fieldSizeSliderPanel());
        panel.add(winCountForVictoryPanel());
        btnStart = new JButton("Start new game");

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(0, 3, 3, 3);
            }
        });

        add(panel);
        add(btnStart, BorderLayout.SOUTH);
    }

    private JPanel fieldSizeSliderPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel fieldSizeLabel = new JLabel("Выберите размер поля");
        JLabel fieldSizeValue = new JLabel("Установленный размер поля: 3");
        JSlider slider = new JSlider(3, 10, 3);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentFieldSize = slider.getValue();
                fieldSizeValue.setText("Установленный размер поля: " + currentFieldSize);
            }
        });
        panel.add(fieldSizeLabel);
        panel.add(fieldSizeValue);
        panel.add(slider);
        return panel;
    }

    private JPanel winCountForVictoryPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel winLengthLabel = new JLabel("Выберите длину для победы");
        JLabel winLengthValue = new JLabel("Установленная длина: 3");
        JSlider slider = new JSlider(3, 10, 3);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentWinLength = slider.getValue();
                winLengthValue.setText("Установленная длина: " + currentWinLength);
            }
        });
        panel.add(winLengthLabel);
        panel.add(winLengthValue);
        panel.add(slider);
        return panel;
    }

    private JPanel gameModePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel label = new JLabel("Выберите режим игры");
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioButton = new JRadioButton("Человек против компьютера");
        JRadioButton radioButton2 = new JRadioButton("Человек против человека");
        buttonGroup.add(radioButton);
        buttonGroup.add(radioButton2);
        panel.add(label);
        panel.add(radioButton);
        panel.add(radioButton2);
        return panel;
    }
}
