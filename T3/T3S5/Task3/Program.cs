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

// Формируем новый одномерный массив, состоящий из средних арифметических значений по строкам двумерного массива
static int[] SumAverageByRowMatrix(int[,] matrix)
{
    int[] newArray = new int[matrix.GetLength(0)];
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        int sum = 0;
        for (int j = 0; j < matrix.GetLength(1); sum += matrix[i, j], j++) ;
        newArray[i] = sum / matrix.GetLength(1);
    }
    return newArray;
}

int[,] matrix = CreateRandomMatrix(4, 4, 1, 10);
ShowMatrix(matrix);
int[] sumAverage = SumAverageByRowMatrix(matrix);
Console.WriteLine("SumAverageByRowMatrix => [" + string.Join(" ", sumAverage) + "]");