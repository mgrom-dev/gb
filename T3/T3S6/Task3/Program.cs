using System.Runtime.CompilerServices;

static int CountVowels(string str)
{
    int count = 0;
    foreach(char c in str)
        if ("aoeiuy".Contains(c)) count++;
    return count;
}

Console.Write("Введите строку: ");
string str = Console.ReadLine()!;
int count = CountVowels(str);
Console.WriteLine(str + " => " + count);