Console.WriteLine("Определяем является ли в первое число квадратом второго. Введите два числа");
try
{
    int number1 = ReadInt();
    int number2 = ReadInt();
    if (number2 * number2 == number1)
    {
        Console.WriteLine("Первое число является квадратом второго");
    }
    else
    {
        Console.WriteLine("Первое число не является квадратом второго");
    }
}
catch (FormatException)
{
    Console.WriteLine("Ошибка: введенное значение не является целым числом");
}
Console.Write("Press any key to continue...");
Console.ReadKey(true);
Console.Clear();

// Чтение целого значения
int ReadInt()
{
    Console.Write("Введите целое число: ");
    int number = Convert.ToInt32(Console.ReadLine());
    return number;
}