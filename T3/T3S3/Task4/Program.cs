// Создание массива из 3-х значного числа
Console.Clear();
Random rand = new();
int number = rand.Next(100, 999);
int[] array = [number % 10, number % 100 / 10, number / 100];
Console.WriteLine("{0} => [{1}]", number, string.Join(" ", array));