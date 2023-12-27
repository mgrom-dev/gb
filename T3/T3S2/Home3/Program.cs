int number = 0;
while(number < 10 || number > 99)
{
    Console.Write("Введите число от 10 до 99: ");
    if (!int.TryParse(Console.ReadLine(), out number))
    {
        Console.WriteLine("Ошибка при вводе числа");
    }
}
int firstNumber = number / 10;
int secondNumber = number % 10;
Console.WriteLine(firstNumber > secondNumber ? firstNumber : secondNumber);