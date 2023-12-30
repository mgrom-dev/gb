void FillArray(int[] arr)
{
    Random rand = new Random();
    for (int i = 0; i < arr.Length; i++)
    {
        arr[i] = rand.Next(1, 100);
    }
}

void PrintArray(int[] arr)
{
    foreach(int i in arr)
    {
        Console.Write($"{i} ");
    }
    Console.WriteLine();
}

int GetSumOfElements(int[] arr)
{
    int sum = 0;
    foreach(int e in arr)
    {
        sum += e;
    }
    return sum;
}

long GetProductOfElements(int[] arr)
{
    int product = 1;
    foreach(int e in arr)
    {
        product *= e;
    }
    return product;
}

int n = 10;
int[] arr = new int [n];
FillArray(arr);
PrintArray(arr);
int sum = GetSumOfElements(arr);
long product = GetProductOfElements(arr);
Console.WriteLine(sum);
Console.WriteLine(product);