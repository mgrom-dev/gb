// создание двумерной матрицы заданной размерности со случайными значениями
using System.Data;

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

// Удаляем строку и столбец, на пересечении которых расположен наименьший элемент массива. 
static void RemoveRowColWithMinElementMatrix(ref int[,] matrix)
{
    int min = matrix[0, 0];
    int deleteRow = 0;
    int deleteCol = 0;
    int[,] newArray = new int[matrix.GetLength(0) - 1, matrix.GetLength(1) - 1];
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
            if (matrix[i, j] < min)
                (min, deleteRow, deleteCol) = (matrix[i, j], i, j);
    }
    for (int i = 0, i2 = 0; i < matrix.GetLength(0); i++)
    {
        if (i == deleteRow) continue;
        for (int j = 0, j2 = 0; j < matrix.GetLength(1); j++)
        {
            if (j == deleteCol) continue;
            else newArray[i2, j2] = matrix[i, j];
            j2++;
        }
        i2++;
    }
    matrix = newArray;
}

int[,] matrix = CreateRandomMatrix(4, 4, 1, 10);
ShowMatrix(matrix);
RemoveRowColWithMinElementMatrix(ref matrix);
Console.WriteLine("RemoveRowColWithMinElementMatrix => ");
ShowMatrix(matrix);