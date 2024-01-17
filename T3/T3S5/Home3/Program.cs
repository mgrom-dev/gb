// создание двумерной матрицы заданной размерности со случайными значениями
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

// Найти индекс строки с наименьшей суммой элементов.  
static int GetIndexRowWithMinSumMatrix(int[,] matrix)
{
    int index = 0;
    int minSum = 0;
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        int sum = 0;
        for (int j = 0; j < matrix.GetLength(1); sum += matrix[i, j], j++) ;
        if (sum < minSum || minSum == 0)
            (index, minSum) = (i, sum);
    }
    return index;
}

int[,] matrix = CreateRandomMatrix(4, 4, 1, 10);
ShowMatrix(matrix);
Console.WriteLine("Строка с индексом => " + GetIndexRowWithMinSumMatrix(matrix));