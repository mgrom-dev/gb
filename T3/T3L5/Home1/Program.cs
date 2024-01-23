static int Fact(int number)
{
    int sum = number;
    if (number < 2) return 1;
    sum *= Fact(number - 1);
    Console.WriteLine($"number: {number}, sum: {sum}");
    return sum;
}

Console.WriteLine(Fact(10));