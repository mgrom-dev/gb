using System;

public class Answer {
    static void PrintEvenNumbers(int number)
    {
        int i = 2;
        Console.Write($"number = {number} -> ");
        while(i <= number)
        {
            Console.Write($"{i}\t");
            i += 2;
        }
    }


  // Не удаляйте и не меняйте метод Main! 
    static public void Main(string[] args) {
        int number;

        if (args.Length >= 1) {
            number = int.Parse(args[0]);
        } else {
           // Здесь вы можете поменять значения для отправки кода на Выполнение
            number = 6;
        }

        // Не удаляйте строки ниже
        PrintEvenNumbers(number);
    }
}