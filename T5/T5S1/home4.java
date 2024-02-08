import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class home4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.toLowerCase().contains("exit")) {
            System.out.println("Введите уравнение вида: q + w = e, где q, w, e >= 0.");
            System.out.println("Вместо цифр можно ставить ?, например: 2? + ?5 = 35. Для выхода введите exit:");
            input = scanner.nextLine();
            // 1. проверяем введеную строку на соотвествие уравнению
            // 2. разбиавем строку по символам и запоминаем позиции всех символов ?
            // 3. вычисляем количество всех комбинации в зависимости от количества вопросов
            // 4. перебираем комбинации и проверяем решилось ли уравнение
            if (input.matches(" *[\\d?]+ *\\+ *[\\d?]+ *= *[\\d?]+")) {
                char[] charArray = input.toCharArray();
                List<Integer> questionPositions = new ArrayList<>();
                String solved = "";
                for (int i = 0; i < charArray.length; i++)
                    if (charArray[i] == '?')
                        questionPositions.add(i);
                for (int variant = 0, max = (int) Math.pow(10, questionPositions.size()); variant < max; variant++) {
                    char[] numbers = String.format("%0" + questionPositions.size() + "d", variant).toCharArray();
                    for (int v = 0; v < questionPositions.size(); v++)
                        charArray[questionPositions.get(v)] = numbers[v];
                    if (isSolved(new String(charArray)))
                        solved = new String(charArray);
                }
                System.out.println(solved.isEmpty() ? "У уравнения нет решений!" : "Решение уравнения: " + solved);
            } else if (!input.toLowerCase().contains("exit"))
                System.out.println("Ошибка ввода выражения, попробуйте еще раз.");
        }
        scanner.close();
    }

    // проверяем решено ли равенство
    public static boolean isSolved(String equation) {
        int[] equationTerms = Arrays.stream(equation.replaceAll(" ", "").split("[+=]"))
                .mapToInt(Integer::parseInt).toArray();
        return equationTerms[0] + equationTerms[1] == equationTerms[2];
    }
}
