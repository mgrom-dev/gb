// Задайте значения M и N. Напишите программу, которая выведет все натуральные числа в промежутке от M до N. Использовать рекурсию, не использовать циклы.

static int ReadInt(string message)
{
    int number = 0;
    do
        Console.Write(message);
    while(! int.TryParse(Console.ReadLine(), out number));
    return number;
}

static void PrintNumbers(int start, int end)
{
    if (start > end)
        return ;
    Console.Write(start + (start == end ? "\"" : ", "));
    PrintNumbers(start + 1, end);
}

int M = ReadInt("Введите М: ");
int N = ReadInt("Введите N: ");
Console.Write($"M = {M}; N = {N} -> \"");
PrintNumbers(M, N);