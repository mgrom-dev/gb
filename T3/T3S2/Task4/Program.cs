int number = 0;
while (number == 0)
{
    Console.Write("Введите число: ");
    if (!int.TryParse(Console.ReadLine(), out number))
    {
        Console.WriteLine("Не верный ввод!");
    }
}
if (number < 100 && number > -100)
{
    Console.WriteLine("Третьей цифры нет");
}
else
{
    Console.WriteLine(Math.Abs(number / 100 % 10));
}