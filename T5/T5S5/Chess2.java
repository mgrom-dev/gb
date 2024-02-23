/**
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
 */
public class Chess2 {
    public static void main(String[] args) {
        int N = 8; // Размер доски
        int[][] board = new int[N][N];

        if (solveNQueens(board, 0, N)) {
            printBoard(board);
        } else {
            System.out.println("Решение не найдено");
        }
    }

    public static boolean solveNQueens(int[][] board, int col, int N) {
        if (col >= N) {
            return true; // Все ферзи расставлены
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1; // Расставляем ферзя

                if (solveNQueens(board, col + 1, N)) {
                    return true; // Ферзи успешно расставлены на остальных колонках
                }

                board[i][col] = 0; // Отменяем ход, если следующие ферзи не могут быть расставлены
            }
        }

        return false; // Не удается расставить ферзей на данной колонке
    }

    public static boolean isSafe(int[][] board, int row, int col, int N) {
        // Проверка по горизонтали
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Проверка по диагонали слева вверх
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Проверка по диагонали слева вниз
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print((num == 1 ? "Q" : ".") + "\t");
            }
            System.out.println();
        }
    }
}
