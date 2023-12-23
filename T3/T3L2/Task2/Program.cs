// Создаем массив и заполняем числами
int[] array = new int[10];
Random randomInteger = new Random();
Console.Write("Задан массив: [");
for (int i = 0; i < array.Length; i++)
{
    array[i] = randomInteger.Next(1, 100);
    if (i != 0)
    {
        Console.Write(", ");
    }
    Console.Write(array[i]);
}
Console.WriteLine("]\nЧетные элементы массива:");
for (int i = 0; i < array.Length; i++)
{
    if (array[i] % 2 == 0)
    {
        Console.Write(array[i] + " ");
    }
}
Console.Write("\nPress any key to continue...");
Console.ReadKey(true);
Console.Clear();