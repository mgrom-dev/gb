// создание массива целых чисел со случайными значениями
static int[] CreateArrayRandomInt(int size = 10, int minValue = 0, int maxValue = 100)
{
    Random rand = new();
    int[] array = new int[size > 0 ? size : 0];
    for (int i = 0; i < size; i++)
        array[i] = rand.Next(minValue, maxValue);
    return array;
}

// преобразовать массив в строку
static string ConvertArrayToString<T>(T[] array, string delimiter = " ") where T : IFormattable
{
    return "[" + string.Join(delimiter, array) + "]";
}

// преобразование массива в целое число
static int EvenNumbersFromArray(int[] array)
{
    int count = 0;
    foreach (int number in array)
        if (number % 2 == 0)
            count++;
    return count;
}

int size = 10;
int[] array = CreateArrayRandomInt(size, 100, 1000);
int count = EvenNumbersFromArray(array);
Console.WriteLine(ConvertArrayToString(array) + " => " + count);