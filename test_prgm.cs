using System;

public class Program
{
    public static void Main()
    {
        // ввести целое число с клавиатуры
        static int ReadIntNumber(string inputMessage = "Введите целое число: ")
        {
            int number = 0;
            while (true)
            {
                Console.Write(inputMessage);
                if (int.TryParse(Console.ReadLine(), out number))
                    return number;
                else
                    Console.WriteLine("Ошибка! Введите целое число.");
            }
        }

        // создание массива целых чисел со случайными значениями
        static int[] CreateArrayRandomInt(int size = 10, int minValue = 0, int maxValue = 100)
        {
            Random rand = new();
            int[] array = new int[size > 0 ? size : 0];
            for (int i = 0; i < size; i++)
                array[i] = rand.Next(minValue, maxValue);
            return array;
        }

        // преобразовать массив в строку
        static string ConvertArrayToString<T>(T[] array, string delimiter = " ") where T : IFormattable
        {
            return "[" + string.Join(delimiter, array) + "]";
        }

        // определение количества простых чисел в массиве
        static int GetCountSimpleNumbers(int[] array)
        {
            // проверка числа на простоту
            static bool IsSimple(int number)
            {
                if (number < 2)
                    return false;
                for (int i = 2; i <= Math.Sqrt(number); i++)
                    if (number % i == 0)
                        return false;
                return true;
            }
            int count = 0;
            foreach (int number in array)
                if (IsSimple(number)) count++;
            return count;
        }

        int size = ReadIntNumber("Введите количество элементов массива: ");
        int[] array = CreateArrayRandomInt(size);
        int count = GetCountSimpleNumbers(array);
        Console.WriteLine(ConvertArrayToString(array) + " => " + count);
    }
}