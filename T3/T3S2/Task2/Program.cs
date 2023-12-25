int number = 0;
while (!(number > 99 && number < 1000))
{
    Console.Write("Введите трёхзначное число: ");
    if (!int.TryParse(Console.ReadLine(), out number))
    {
        Console.WriteLine("Не верный ввод!");
    }
}
double result = Math.Pow(number % 100 / 10, number % 10);
Console.WriteLine(result);