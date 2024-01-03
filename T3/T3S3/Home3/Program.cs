// Подсчет разницы между минимальным и максимальным элементом массива
Console.Clear();
Random rand = new();
int size = 10;
float[] array = new float[size];
float min = 10_000;
float max = 0;
for (int i = 0; i < array.Length; i++)
{
    array[i] = (float) rand.Next(1, 10_000) / 100;
    if (array[i] > max)
    {
        max = array[i];
    }
    if (array[i] < min)
    {
        min = array[i];
    }
}
Console.WriteLine("[{0}] => {1}", string.Join(" ", array), max - min);