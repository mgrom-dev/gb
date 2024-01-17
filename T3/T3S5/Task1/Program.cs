// создание двумерной матрицы заданной размерности со случайными значениями
using System.Collections.ObjectModel;

static int[,] CreateRandomMatrix(int rows, int cols, int minValue = 0, int maxValue = 100)
{
    Random rand = new Random();
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

// возводим в квадрат элементы массива у которых индексы оба четные
static void ModifficateMatrix(int[,] matrix)
{
    for (int i = 0; i < matrix.GetLength(0); i++)
        for (int j = 0; j < matrix.GetLength(1); j++)
            if (i == j && i % 2 == 0)
                matrix[i, j] *= matrix[i, j];
}

int[,] matrix = CreateRandomMatrix(4, 4, 1, 10);
ShowMatrix(matrix);
ModifficateMatrix(matrix);
Console.WriteLine("ModifficateMatrix => ");
ShowMatrix(matrix);