using System;

public class Program
{
    public static void Main()
    {
        // ������ ����� ����� � ����������
        static int ReadIntNumber(string inputMessage = "������� ����� �����: ")
        {
            int number = 0;
            while (true)
            {
                Console.Write(inputMessage);
                if (int.TryParse(Console.ReadLine(), out number))
                    return number;
                else
                    Console.WriteLine("������! ������� ����� �����.");
            }
        }

        // �������� ������� ����� ����� �� ���������� ����������
        static int[] CreateArrayRandomInt(int size = 10, int minValue = 0, int maxValue = 100)
        {
            Random rand = new();
            int[] array = new int[size > 0 ? size : 0];
            for (int i = 0; i < size; i++)
                array[i] = rand.Next(minValue, maxValue);
            return array;
        }

        // ������������� ������ � ������
        static string ConvertArrayToString<T>(T[] array, string delimiter = " ") where T : IFormattable
        {
            return "[" + string.Join(delimiter, array) + "]";
        }

        // ����������� ���������� ������� ����� � �������
        static int GetCountSimpleNumbers(int[] array)
        {
            // �������� ����� �� ��������
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

        int size = ReadIntNumber("������� ���������� ��������� �������: ");
        int[] array = CreateArrayRandomInt(size);
        int count = GetCountSimpleNumbers(array);
        Console.WriteLine(ConvertArrayToString(array) + " => " + count);
    }
}