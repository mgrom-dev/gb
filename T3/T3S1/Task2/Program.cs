Console.WriteLine("Введите целое число N");
try
{
    int number = ReadInt();
    int i = number * -1;
    Console.Write(number + " => " + i);
    while(i < number)
    {
        i++;
        Console.Write(", " + i);
    }
    Console.WriteLine();
}
catch (FormatException)
{
    Console.WriteLine("Ошибка: введенное значение не является целым числом");
}
Console.Write("Press any key to continue...");
Console.ReadKey(true);
Console.Clear();

// Чтение целого значения
static int ReadInt()
{
    Console.Write("Введите целое число: ");
    int number = Convert.ToInt32(Console.ReadLine());
    return number;
}