using System.Runtime.CompilerServices;

static string JoinCharsTwoDimArray(char[,] array)
{
    string str = "";
    foreach (char c in array)
        str += c;
    return str;
}

char[,] array = {
    {'a', 'b', 'c'},
    {'d', 'e', 'f'}
};
string str = JoinCharsTwoDimArray(array);
Console.Write(str);