int number1 = 0;
int number2 = 0;
while (number1 == 0)
{
    Console.Write("Введите первое число: ");
    if (!int.TryParse(Console.ReadLine(), out number1))
    {
        Console.WriteLine("Не верный ввод!");
    }
}
while (number2 == 0)
{
    Console.Write("Введите второе число: ");
    if (!int.TryParse(Console.ReadLine(), out number2))
    {
        Console.WriteLine("Не верный ввод!");
    }
}
int mod = number1 % number2;
if (mod == 0)
{
    Console.WriteLine("да");
}
else
{
    Console.WriteLine("нет, " + mod);
}