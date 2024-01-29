// Задайте произвольный массив. Выведете его элементы, начиная с конца. Использовать рекурсию, не использовать циклы.  

static int ReadInt(string message)
{
    int number = 0;
    do
        Console.Write(message);
    while(! int.TryParse(Console.ReadLine(), out number) && number > 0);
    return number;
}

static int[] GenerateRandomIntArray(int size)
{
    int[] array = new int[size];
    Random rand = new();
    for (int i = 0; i < array.Length; array[i] = rand.Next(1, 100), i++) ;
    return array;
}

static void ReversePrintArray(int[] array, int i = 0)
{
    if (i < array.Length)
        ReversePrintArray(array, i + 1);
    else
        return ;
    Console.Write(" " + array[i]);
}

int size = ReadInt("Введите размер массива: ");
int[] array = GenerateRandomIntArray(size);
Console.Write($"[{ string.Join(", ", array) }] =>");
ReversePrintArray(array);