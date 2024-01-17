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

// получение целого числа из консоли
static int GetIntFromConsole(string message)
{
    int number = 0;
    while (true)
    {
        Console.Write(message);
        if (int.TryParse(Console.ReadLine(), out number))
            return number;
        else
            Console.WriteLine("Ошибка! Введите целое число.");
    }
}

// печатаем значение элемента по индексу двумерного массива
static void PrintElementMatrix(int[,] matrix, int row, int col)
{
    if (row < 0 || row > matrix.GetLength(0) - 1 || col < 0 || col > matrix.GetLength(1) - 1)
        Console.WriteLine("элемента по заданной позиции нету в таблице.");
    else
        Console.WriteLine("Элемент найден: " + matrix[row, col]);
}

int[,] matrix = CreateRandomMatrix(4, 4, 1, 10);
ShowMatrix(matrix);
int row = GetIntFromConsole("введите строку: ");
int col = GetIntFromConsole("введите столбец: ");
PrintElementMatrix(matrix, row, col);