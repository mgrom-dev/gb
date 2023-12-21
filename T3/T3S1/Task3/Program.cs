Console.WriteLine("Введите целое трехзначное число: ");
try
{
    string input = Console.ReadLine()!;
    if (input.Length != 3) 
    {
        throw new Exception("Ошибка, введеное значение не трехзначное");
    }
    int number = Convert.ToInt32(input);
    int num1 = Convert.ToInt32(new string([input[0]]));
    int num3 = Convert.ToInt32(new string([input[2]]));
    Console.WriteLine(number + " => " + (num1 + num3));
}
catch (FormatException)
{
    Console.WriteLine("Ошибка: введенное значение не является целым числом");
}
catch (Exception e)
{
    Console.WriteLine(e.Message);
}
Console.Write("Press any key to continue...");
Console.ReadKey(true);
Console.Clear();