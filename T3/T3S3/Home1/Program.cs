// Подсчет количества элементов массива, значения которых лежат в отрезке [20, 90]
Console.Clear();
Random rand = new();
int size = 10;
int[] array = new int[size];
int count = 0;
for (int i = 0; i < array.Length; i++)
{
    array[i] = rand.Next(1, 100);
    if (array[i] >= 20 && array[i] <= 90)
    {
        count++;
    }
}
Console.WriteLine("[{0}] => {1}", string.Join(" ", array), count);