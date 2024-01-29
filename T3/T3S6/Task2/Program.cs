using System.Runtime.CompilerServices;

static char[] StringtoChars(string str)
{
    char[] array = new char[str.Length];
    for (int i = 0; i < str.Length; i++)
        array[i] = str[i];
    return array;
}

string str = "Hello!";
char[] array = StringtoChars(str);
Console.WriteLine("[" + string.Join(",", array) + "]");