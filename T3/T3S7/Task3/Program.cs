// Считать строку с консоли, содержащую латинские буквы. Вывести на экран согласные буквы этой строки.

static void PrintConsonants(string str)
{
    const string CONSONANTS = "BCDFGHJKLMNPQRSTVWXZ";
    if (CONSONANTS.Contains(str.ToUpper()[0]))
        Console.Write(" " + str[0]);
    if (str.Length > 1)
        PrintConsonants(str[1..]);
}

Console.Write("Введите строку: ");
string str = Console.ReadLine() ?? "";
Console.Write($"\"{str}\" =>");
PrintConsonants(str);