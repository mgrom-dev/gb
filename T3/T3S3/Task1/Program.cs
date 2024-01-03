// Поиск заданного числа в массиве случайных чисел
int size = 10;
int[] array = new int[size];
int number;
Random rand = new();
for (int i = 0; i < array.Length; i++)
{
    array[i] = rand.Next(1,10);
}
while (true)
{
    Console.Write("Введите целое число: ");
    if (int.TryParse(Console.ReadLine(), out number))
    {
        break;
    } else
    {
        Console.WriteLine("Ошибка ввода целого числа");
    }
}
bool exist = false;
foreach (int num in array)
{
    if (num == number)
    {
        exist = true;
        break;
    }
}
Console.WriteLine("Проверка существования числа {0} в массиве: [{1}]", number, string.Join(", ", array));
Console.WriteLine(exist ? "Да" : "Нет");