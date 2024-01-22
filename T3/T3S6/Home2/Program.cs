using System.Runtime.CompilerServices;

static string ToLowerCase(string str)
{
    string result = "";
    foreach (char c in str)
        result += (char)(c > 64 && c < 91 ? c + 32 : c);
    return result;
}

string str = "aBcD1ef!-";
Console.Write(str + " => " + ToLowerCase(str));