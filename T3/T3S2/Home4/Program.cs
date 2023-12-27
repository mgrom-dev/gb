int number = 0;
while (number == 0)
{
    Console.Write("Введите число: ");
    if (!int.TryParse(Console.ReadLine(), out number))
    {
        Console.WriteLine("Ошибка при вводе числа");
    }
}
int divisor = 1;
// Находим делитель для определения разряда числа
while (number / divisor >= 10)
{
    divisor *= 10;
}
// Вывод цифр через запятую
while (divisor != 0)
{
    int digit = number / divisor;
    number %= divisor;
    divisor /= 10;
    Console.Write(digit + (number != 0 ? "," : ""));
}