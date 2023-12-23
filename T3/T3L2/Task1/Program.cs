while(true)
{
    try
    {
        // Ввод размерности массива
        Console.Write("Введите размер массива: ");
        int size = Convert.ToInt32(Console.ReadLine());
        if (size < 1)
        {
            throw new Exception("Ошибка, размер массива должен быть больше 0");
        }
        // Ввод максимального значения массива
        Console.Write("Введите значения массива от 1 до : ");
        int N = Convert.ToInt32(Console.ReadLine());
        if (N < 2)
        {
            throw new Exception("Ошибка, значение должно быть больше 1");
        }
        // Создаем массив и заполняем числами
        int[] array = new int[size];
        Random randomInteger = new Random();
        Console.Write("Задан массив: [");
        for (int i = 0; i < array.Length; i++)
        {
            array[i] = randomInteger.Next(1, N);
            if (i != 0) {
                Console.Write(", ");
            }
            Console.Write(array[i]);
        }
        Console.WriteLine("]");
        Console.Write("Press any key to continue...");
        Console.ReadKey(true);
        Console.Clear();
        break;
    }
    catch (FormatException)
    {
        Console.WriteLine("Ошибка: введенное значение не является целым числом");
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}