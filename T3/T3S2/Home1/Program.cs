int number = 0;
while(number == 0)
{
    Console.Write("Введите число: ");
    if (!int.TryParse(Console.ReadLine(), out number))
    {
        Console.WriteLine("Ошибка при вводе числа");
    }
}
if (number % 7 == 0 && number % 23 == 0)
{
    Console.WriteLine("да");
}
else
{
    Console.WriteLine("нет");
}