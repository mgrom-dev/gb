// ввести целое число с клавиатуры
static int ReadIntNumber(string inputMessage = "Введите целое число: ")
{
    int number = 0;
    while (true)
    {
        Console.Write(inputMessage);
        if (int.TryParse(Console.ReadLine(), out number))
            return number;
        else
            Console.WriteLine("Ошибка! Введите целое число.");
    }
}

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

// определение количества целых чисел в массиве, которые оканчиваются на 1 и делятся нацело на 7
static int GetCountNumbersEnd1DivideBy7(int[] array)
{
    int count = 0;
    foreach(int number in array)
        if (number % 10 == 1 && number % 7 == 0) count++;
    return count;
}

int size = ReadIntNumber("Введите количество элементов массива: ");
int[] array = CreateArrayRandomInt(size);
int count = GetCountNumbersEnd1DivideBy7(array);
Console.WriteLine(ConvertArrayToString(array) + " => " + count);