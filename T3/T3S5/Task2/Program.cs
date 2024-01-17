// создание двумерной матрицы заданной размерности со случайными значениями
using System.Collections.ObjectModel;

static int[,] CreateRandomMatrix(int rows, int cols, int minValue = 0, int maxValue = 100)
{
    Random rand = new();
    int[,] maxtrix = new int[rows, cols];
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            maxtrix[i, j] = rand.Next(minValue, maxValue);
    return maxtrix;
}

// печать двумерной матрицы
static void ShowMatrix(int[,] matrix)
{
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
            Console.Write(matrix[i, j] + " ");
        Console.WriteLine();
    }
}

// Считаем сумму элементов, находящихся на главной диагонали с индексами (0,0); (1;1) и т.д.
static int SumDiagonalMatrix(int[,] matrix)
{
    int sum = 0;
    for (int i = 0; i < matrix.GetLength(0); i++)
        for (int j = 0; j < matrix.GetLength(1); j++)
            if (i == j)
                sum += matrix[i, j];
    return sum;
}

int[,] matrix = CreateRandomMatrix(4, 4, 1, 10);
ShowMatrix(matrix);
Console.WriteLine("SumDiagonalMatrix => " + SumDiagonalMatrix(matrix));