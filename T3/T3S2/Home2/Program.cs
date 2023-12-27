// Домашняя работа 2
int x = 0,
    y = 0;
while(x == 0 || y == 0)
{
    if (x == 0)
    {
        Console.Write("Введите координаты точки x: ");
        if (!int.TryParse(Console.ReadLine(), out x))
        {
            Console.WriteLine("Ошибка при вводе координаты x");
            continue;
        }
    }
    if (y == 0)
    {
        Console.Write("Введите координаты точки y: ");
        if (!int.TryParse(Console.ReadLine(), out y))
        {
            Console.WriteLine("Ошибка при вводе координаты y");
        }
    }
}
if (x > 0)
{
     Console.WriteLine(y > 0 ? "1" : "4");
}
else
{
    Console.WriteLine(y > 0 ? "2" : "3");
}
