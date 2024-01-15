/// программа бесконечно запрашивает целые числа
/// программа завершается когда пользователь введет q, либо сумма цифр числа четная
int number = 0;
string str = "";
while (true)
{
    Console.Write("Введите целое число, или введите q для выхода из программы: ");
    str = Console.ReadLine()!;
    if (str == "q") break;
    if (int.TryParse(str, out number))
    {
        int sum = str.Select(digit => int.Parse(digit.ToString())).ToArray().Sum();
        if (sum % 2 == 0)
        {
            Console.WriteLine("Сумма цифр последнего числа, четная. Выход из программы");
            break;
        }
    }
    else
        Console.WriteLine("Ошибка! Введите целое число.");
}
Console.Write(" [STOP]");