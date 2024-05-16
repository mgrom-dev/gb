package ru.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CrossZeroGame {
    private static Scanner scan = null;
    private static Random rand = null;
    /* путь к файлу для сохранения игры */
    private static final String PATH_SAVES = "save.data";
    /* символы клеток игрока и компьютера */
    private static final char PL = 'X';
    private static final char PC = 'O';

    private char[][] board;
    private boolean gameover;
    private boolean win;

    {
        if (scan == null)
            scan = new Scanner(System.in);

        if (rand == null)
            rand = new Random();

        board = new char[3][3];
        char c = '0';
        for (char[] row : board)
            for (byte i = 0; i < row.length; i++)
                row[i] = ++c;

        gameover = false;
        win = false;
    }

    /** начало игры */
    public void startGame() {
        while (!gameover)
            nextMove();
        System.out.println(win ? "You win!" : "You lose!");
    }

    /** следующий ход */
    private void nextMove() {
        printBoard();
        if (checkForWin())
            return;

        turnPlayer();
        printBoard();

        if (checkForWin())
            return;
        turnComputer();
    }

    /** ход игрока */
    private void turnPlayer() {
        System.out.println("Enter number of cell 1..9");
        int cell = -1;
        while (cell == -1) {
            /* если данные в консоли не являются числом, то возможно это функции игры */
            if (!scan.hasNextInt()) {
                String line = scan.nextLine().toLowerCase();
                if (line.equals("q") || line.equals("quit")) { // выход из игры
                    gameover = true;
                    return;
                } else if (line.equals("s") || line.equals("save")) { // сохранить игру
                    saveGame();
                } else if (line.equals("l") || line.equals("load")) { // загрузить игру
                    loadGame();
                }
                continue;
            }
            cell = scan.nextInt() - 1;
            if (cell >= 9 || cell < 0 || board[cell / 3][cell % 3] > '9') {
                cell = -1;
            } else
                board[cell / 3][cell % 3] = PL;
        }
    }

    /** ход компьютера */
    private void turnComputer() {
        int cell = -1;
        while (cell == -1) {
            cell = rand.nextInt(10);
            if (cell >= 9 || cell < 0 || board[cell / 3][cell % 3] > '9') {
                cell = -1;
            } else
                board[cell / 3][cell % 3] = PC;
        }
    }

    /** проверка на выигрыш, или проигрыш */
    private boolean checkForWin() {
        /** проверка 3 ячеек на совпадения */
        class Condition {
            boolean checkWin(char a, char b, char c) {
                char symbol = a == b && c == b ? a : 0;
                if (symbol == PL || symbol == PC) {
                    gameover = true;
                    win = symbol == PL;
                    return true;
                }
                return false;
            }
        }
        Condition condition = new Condition();

        /* совпадения по горизонту */
        boolean win = condition.checkWin(board[0][0], board[0][1], board[0][2])
                || condition.checkWin(board[1][0], board[1][1], board[1][2])
                || condition.checkWin(board[2][0], board[2][1], board[2][2])
                /* совпадения по вертикали */
                || condition.checkWin(board[0][0], board[1][0], board[2][0])
                || condition.checkWin(board[0][1], board[1][1], board[2][1])
                || condition.checkWin(board[0][2], board[1][2], board[2][2])
                /* совпадения по горизонтали */
                || condition.checkWin(board[0][0], board[1][1], board[2][2])
                || condition.checkWin(board[0][2], board[1][1], board[2][0]);

        return win;
    }

    /** печать поля в консоль */
    private void printBoard() {
        /** отображение ячейки поля с цветом */
        class Cell {
            private String cell;

            Cell(char ch) {
                /* проверяем поддержку ansi-escape последовательностей */
                if (System.console() != null && System.getenv().get("TERM") != null) {
                    ANSI color = ch == PL ? ANSI.GREEN : (ch == PC ? ANSI.YELLOW : ANSI.WHITE);
                    cell = String.format("%s %c \u001B[0m", color, ch);
                } else {
                    cell = String.format(" %c ", ch);
                }
            }

            @Override
            public String toString() {
                return cell;
            }
        }

        /* очистка консоли */
        if (System.console() != null && System.getenv().get("TERM") != null) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } else {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }

        /* отрисовка поля */
        System.out.println("Commands: Quit, Save or Load");
        for (int i = 0; i < 3; i++) {
            if (i > 0)
                System.out.printf("---+---+---\n");
            System.out.printf("%s|%s|%s\n", new Cell(board[i][0]), new Cell(board[i][1]), new Cell(board[i][2]));
        }
    }

    /** сохранение игры */
    private void saveGame() {
        /* записываем данные в строку в двоичном виде */
        byte[] bytes = new byte[3];
        StringBuilder sb = new StringBuilder();
        for (char[] row : board)
            for (char ch : row)
                sb.append(ch == PL ? "10" : (ch == PC ? "01" : "00"));

        /* переводим данные из строки в байты */
        for (int i = 0, j = 0, len = sb.length(); i < len; i += 8, j++) {
            if (i + 8 < len) {
                bytes[j] = (byte) Integer.parseInt(sb.substring(i, i + 8), 2);
            } else {
                bytes[j] = (byte) Integer.parseInt(sb.substring(i, len), 2);
            }
        }

        /* записываем данные в файл */
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(PATH_SAVES))) {
            dos.write(bytes);
            System.out.println("game saved...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** загрузка игры */
    private void loadGame() {
        /* считываем данные из файла */
        byte[] bytes = new byte[3];
        try (DataInputStream dis = new DataInputStream(new FileInputStream(PATH_SAVES))) {
            bytes = dis.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* переводим данные в строку в двоичном виде */
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) 
            sb.append(String.format("%08d", Integer.parseInt(Integer.toBinaryString(Byte.toUnsignedInt(b)))));

        /* сбрасываем поле в начальную позицию */
        char c = '0';
        for (char[] row : board)
            for (byte i = 0; i < row.length; i++)
                row[i] = ++c;

        /* загружаем данные */
        for (int i = 0, j = 0, len = sb.length(); i < len && j < 9; i += 2, j++) {
            String value = sb.substring(i, i + 2);
            if (value.equals("10")) board[j / 3][j % 3] = PL;
            else if (value.equals("01")) board[j / 3][j % 3] = PC;
        }

        printBoard();
        System.out.println("game loaded...");
    }
}
