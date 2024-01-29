// функция формирует массив из целых чисел состоящий из цифр исходной строки
static int[] GetArrayDigitsFromString(string str){
    int count = str.Count(char.IsDigit);
    int[] array = new int[count];
    array = str.Where(char.IsDigit).Select(c => c - '0').ToArray();
    return array;
}

Console.Write("Введите строку: ");
string str = Console.ReadLine()!;
Console.Write("Строка из цифр: ");
Console.WriteLine(string.Join(" ", GetArrayDigitsFromString(str)));