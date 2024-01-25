// Задайте значение N. Напишите программу, которая выведет все натуральные числа в промежутке от 1 до N.

static int ReadInt(string message)
{
    int number = 0;
    do
        Console.Write(message);
    while(! int.TryParse(Console.ReadLine(), out number) && number > 0);
    return number;
}

static void PrintNumbers(int number)
{
    if (number > 1)
        PrintNumbers(number - 1);
    Console.Write(" " + number);
}

int N = ReadInt("Введите число: ");
Console.Write($"N={N} =>");
PrintNumbers(N);