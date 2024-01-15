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
static string ConvertArrayToString<T>(T[] array, string delimiter = " ")
{
    return "[" + string.Join(delimiter, array) + "]";
}

int size = 10;
int[] array = CreateArrayRandomInt(size);
int[] arrayR = Enumerable.Reverse(array).ToArray();
Console.WriteLine(ConvertArrayToString(array) + " => " + ConvertArrayToString(arrayR));