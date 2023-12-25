int number;
while(true)
{
    Console.Write("Введите трёхзначное число: ");
    string input = Console.ReadLine()!;
    if (int.TryParse(input, out number) && number > 99 && number < 1000)
    {
        break;
    }
    else 
    {
        Console.WriteLine("Не верный ввод!");
    }
}
number = number / 100 * 10 + number % 10;
Console.WriteLine(number);