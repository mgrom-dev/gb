using System.Runtime.CompilerServices;

static string CharsToString(char[] array)
{
    string str = "";
    foreach(char c in array)
        str += c;
    return str;
}

char[] array = ['a', 'b', 'c', 'd'];
string str = CharsToString(array);
Console.WriteLine(str);