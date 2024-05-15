package ru.homework;

import java.util.Random;
import java.util.Scanner;

public class CrossZeroGame {
    private static Scanner scan = null;
    private static Random rand = null;
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
                String line = scan.nextLine();
                if (line.equals("q") || line.equals("quit")) { // выход из игры
                    gameover = true;
                    return;
                } else if (line.equals("s") || line.equals("save")) { // сохранить игру
                    System.out.println("save game");
                } else if (line.equals("l") || line.equals("load")) { // загрузить игру
                    System.out.println("load game");
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
                ANSI color = ch == PL ? ANSI.GREEN : (ch == PC ? ANSI.YELLOW : ANSI.WHITE);
                cell = String.format("%s %c \u001B[0m", color, ch);
            }

            @Override
            public String toString() {
                return cell;
            }
        }

        /* очистка консоли */
        System.out.print("\033[H\033[2J");
        System.out.flush();

        /* отрисовка поля */
        for (int i = 0; i < 3; i++) {
            if (i > 0)
                System.out.printf("---+---+---\n");
            System.out.printf("%s|%s|%s\n", new Cell(board[i][0]), new Cell(board[i][1]), new Cell(board[i][2]));
        }
    }
}
