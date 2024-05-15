package ru.homework;

import java.util.Random;
import java.util.Scanner;

public class CrossZeroGame {
    private static Scanner scan = null;
    private static Random rand = null;

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

    /**
     * начало игры
     */
    public void startGame() {
        while (!gameover)
            nextMove();
        System.out.println(win ? "You win!" : "You lose!");
    }

    /**
     * следующий ход
     */
    private void nextMove() {
        printBoard();
        if (checkForWin()) return ;
        
        turnPlayer();
        printBoard();

        if (checkForWin()) return ;
        turnComputer();
    }

    /**
     * ход игрока
     */
    private void turnPlayer() {
        System.out.println("Enter number of cell 1..9");
        int cell = -1;
        while (cell == -1) {
            if (!scan.hasNextInt()) {
                String line = scan.nextLine();
                if (line.equals("q")) {
                    gameover = true;
                    return ;
                }
                continue;
            }
            cell = scan.nextInt() - 1;
            if (cell >= 9 || cell < 0 || board[cell / 3][cell % 3] > '9') {
                cell = -1;
            } else board[cell / 3][cell % 3] = 'X';
        }
    }

    /**
     * ход компьютера
     */
    private void turnComputer() {
        int cell = -1;
        while (cell == -1) {
            cell = rand.nextInt(10);
            if (cell >= 9 || cell < 0 || board[cell / 3][cell % 3] > '9') {
                cell = -1;
            } else board[cell / 3][cell % 3] = 'O';
        }
    }

    /**
     * проверка на выигрыш, или проигрыш
     */
    private boolean checkForWin() {
        /** проверка 3 ячеек на совпадения */
        class Condition {
            boolean checkWin(char a, char b, char c) {
                char symbol = a == b && c == b ? a : 0;
                if (symbol == 'O' || symbol == 'X') {
                    gameover = true;
                    win = symbol == 'X';
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

    /**
     * печать поля в консоль
     */
    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            if (i > 0)
                System.out.printf("---+---+---\n");
            System.out.printf(" \u001B[32m %c \u001B[0m | %c | %c \n", board[i][0], board[i][1], board[i][2]);
        }
    }
}
