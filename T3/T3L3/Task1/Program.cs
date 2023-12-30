double CalculateFormula(int a, int b, int c, int d)
{
    double numerator = a * b;
    int denominator = c + d;
    double result = numerator / denominator;
    return result;
}
Console.WriteLine(CalculateFormula(5, 2, 3, 4));