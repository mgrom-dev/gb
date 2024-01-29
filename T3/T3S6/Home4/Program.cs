static string RevertWords(string str)
{
    return string.Join(" ", str.Split(" ").Reverse());
}

string str = "Hello my world";
Console.WriteLine(str + " => " + RevertWords(str));