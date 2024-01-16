// функция формирует новую строку состоящую из букв исходной строки
static string GetLettersFromString(string str){
    string result = "";
    foreach(char c in str){
        if (char.IsAsciiLetter(c))
            result += c;
    }
    return result;
}

Console.Write("Введите строку: ");
string str = Console.ReadLine()!;
Console.Write("Строка без цифр: ");
Console.WriteLine(GetLettersFromString(str));
