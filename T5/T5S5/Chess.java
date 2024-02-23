/**
 * Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке
 * была строго один раз.
 */
public class Chess {
    public static void main(String[] args) {
        int N = 5; // Размер доски
        int[][] board = new int[N][N];
        solveKnightTour(board, N);
        printBoard(board);
    }

    public static boolean solveKnightTour(int[][] board, int N) {
        // Начальная позиция коня
        int startRow = 0;
        int startCol = 0;

        // Массивы для определения ходов коня
        int[] rowMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] colMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

        // Первый ход
        board[startRow][startCol] = 1;

        // Рекурсивно ищем путь коня
        if (!solveKnightTourUtil(board, startRow, startCol, 2, rowMoves, colMoves, N)) {
            System.out.println("Решение не найдено");
            return false;
        }

        return true;
    }

    public static boolean solveKnightTourUtil(int[][] board, int row, int col, int moveCount, int[] rowMoves,
            int[] colMoves, int N) {
        if (moveCount == N * N + 1) {
            return true; // Найдено решение
        }

        // Перебираем все возможные ходы коня
        for (int i = 0; i < 8; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];

            if (isValidMove(board, newRow, newCol, N)) {
                board[newRow][newCol] = moveCount;
                if (solveKnightTourUtil(board, newRow, newCol, moveCount + 1, rowMoves, colMoves, N)) {
                    return true;
                }
                board[newRow][newCol] = 0; // Откат хода
            }
        }

        return false;
    }

    public static boolean isValidMove(int[][] board, int row, int col, int N) {
        return (row >= 0 && row < N && col >= 0 && col < N && board[row][col] == 0);
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
