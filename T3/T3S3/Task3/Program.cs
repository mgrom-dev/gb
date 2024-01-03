// Считаем произведения пар первого и последнего элемента массива, второго и предпоследнего и т.д.
Console.Clear();
Random rand = new();
int size = rand.Next(5, 10);
int[] array = new int[size];
int[] result = new int[size/2];
for (int i = 0; i < array.Length; i++)
{
    array[i] = rand.Next(1, 10);
}
for (int i = 0; i < array.Length / 2; i++)
{
    result[i] = array[i] * array[^(i + 1)];
}
Console.WriteLine("[{0}] => [{1}]", string.Join(" ", array), string.Join(" ", result));