// Создание массива состоящего из цифр числа от 1 до 100 000
Console.Clear();
int number = 0;
while(true)
{
    Console.Write("Введите число от 1 до 100 000: ");
    if (int.TryParse(Console.ReadLine(), out number) && number >= 1 && number <= 100_000)
    {
        break;
    } else
    {
        Console.WriteLine("Ошибка при вводе числа");
    }
}
int size = 0;
for (int num = number; num != 0; num /= 10, size++) ;
int[] array = new int[size];
for (int i = 0; number != 0; i++, array[^(i)] = number % 10, number /= 10) ;
Console.WriteLine($"{number} => [{string.Join(" ", array)}]");