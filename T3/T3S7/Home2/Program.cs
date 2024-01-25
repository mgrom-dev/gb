// Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n

static int ReadInt(string message)
{
    int number = 0;
    do
        Console.Write(message);
    while(! int.TryParse(Console.ReadLine(), out number));
    return number;
}

static int Accerman(int m, int n)
{
    if (m == 0)
    {
        return n + 1;
    }
    else if (m > 0 && n == 0)
    {
        return Accerman(m - 1, 1);
    }
    else
    {
        return Accerman(m - 1, Accerman(m, n - 1));
    }
}

int M = ReadInt("Введите М: ");
int N = ReadInt("Введите N: ");
Console.WriteLine($"m = {M}, n = {N} -> A(m,n) = {Accerman(M, N)}");