// Создаем массив и заполняем числами
int[] array = new int[10];
Random randomInteger = new Random();
Console.Write("Дано 10 гирь: [");
for (int i = 0; i < array.Length; i++)
{
    array[i] = randomInteger.Next(1, 100);
    if (i != 0)
    {
        Console.Write(", ");
    }
    Console.Write(array[i]);
}
Console.Write("]\nВес самой тяжелой гири: ");
int max = array[0];
for (int i = 1; i < array.Length; i++)
{
    if (array[i] > max)
    {
        max = array[i];
    }
}
Console.Write(max);
Console.Write("\nPress any key to continue...");
Console.ReadKey(true);
Console.Clear();