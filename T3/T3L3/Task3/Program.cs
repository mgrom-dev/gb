void ZeroEvenElements(int[] arr)
{
    for (int i = 0; i < arr.Length; i++)
    {
        if (arr[i] % 2 == 0)
        {
            arr[i] = 0;
        }
    }
}

void PrintArray(int[] arr)
{
    foreach(int i in arr)
    {
        Console.Write($"{i} ");
    }
}

int[] array = [1, 2, 3, 4, 5];
ZeroEvenElements(array);
PrintArray(array);