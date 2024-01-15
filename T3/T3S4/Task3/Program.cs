// ввести целое число с клавиатуры
using System.Runtime.ExceptionServices;

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

// преобразование массива в целое число
static int ConvertArrayToNumber(int[] array)
{
    int number = 0;
    for (int i = 0, size = array.Length; i < size; i++)
        number += array[i] * (int)Math.Pow(10, size - i - 1);
    return number;
}

int size = 0;
while (size < 1 || size > 8)
    size = ReadIntNumber("Введите количество элементов массива от 1 до 8: ");
int[] array = CreateArrayRandomInt(size, 0, 10);
int number = ConvertArrayToNumber(array);
Console.WriteLine(ConvertArrayToString(array) + " => " + number);