static int Fact(int number)
{
    if (number < 2) return 1;
    return number * Fact(number - 1);
}

Console.WriteLine(Fact(10));