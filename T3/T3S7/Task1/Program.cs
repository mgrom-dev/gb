// Напишите программу, которая будет принимать на вход число и возвращать сумму его цифр. 

static int ReadInt(string message)
{
    int number = 0;
    do
        Console.Write(message);
    while(! int.TryParse(Console.ReadLine(), out number) && number > 0);
    return number;
}

static int SumNumbers(int number)
{
    if (number == 0)
        return 0;
    return number % 10 + SumNumbers(number / 10);
}

int number = ReadInt("Введите число: ");
Console.Write($"{number} => {SumNumbers(number)}");