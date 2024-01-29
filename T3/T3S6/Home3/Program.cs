using System.Runtime.CompilerServices;
using System.Text;

static bool IsPalindrome(string str)
{
    for (int i = str.Length / 2 + str.Length % 2; i < str.Length; i++)
        if (str[i] != str[str.Length - i - 1])
            return false;
    return true;
}

// для чтения русских символов из консоли под windows
Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);
System.Console.InputEncoding = Encoding.GetEncoding(1251);
Console.Write("Введите строку: ");
string str = Console.ReadLine()!;
Console.WriteLine(IsPalindrome(str) ? "Да" : "Нет");