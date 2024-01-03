// Замена элементов массива на противоположные
Console.Clear();
int size = 10;
int[] array = new int[size];
Random rand = new();
for (int i = 0; i < array.Length; i++)
{
    array[i] = rand.Next(-10, 10);
}
Console.WriteLine("Задан массив [{0}], изменяем элементы на противополжные...", string.Join(", ", array));
for (int i = 0; i < array.Length; i++)
{
    array[i] *= -1;
}
Console.WriteLine("Итоговый массив: [{0}]", string.Join(", ", array));