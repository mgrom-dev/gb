import java.util.Arrays;
import java.util.Scanner;

class home4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.toLowerCase().contains("exit")) {
            System.out.println(
                    "Введите уравнение вида: q + w = e, где q, w, e >= 0. Некоторые цифры можно заменить знаком вопроса, например: 2? + ?5 = 35. Для выхода введите exit:");
            input = scanner.nextLine();
            // проверяем введеную строку на соотвествие уровнению
            if (input.matches(" *[\\d?]+ *\\+ *[\\d?]+ *= *[\\d?]+")) {
                // разбиваем строку по членам уравнения
                String[] elements = input.replaceAll(" ", "").split("[+=]");
                // ищем решения уравнения
                String[] solved = calcExpression(elements);
                if (isSolved(solved)) {
                    // меняем символы члены выражения с ? на найденное решение
                    for (int i = 0; i < elements.length; i++) {
                        // \\Q и \\E - экранирование регулярного выражения, чтобы оно воспринималось как
                        // строка
                        input = input.replaceFirst("\\Q" + elements[i] + "\\E", solved[i]);
                    }
                    System.out.printf("Решение уравнения: %s\n", input);
                } else {
                    System.out.println("У уравнения нет решений!");
                }
            }
        }
        scanner.close();
    }

    // проверяем решено ли равенство
    public static boolean isSolved(String[] elements) {
        try {
            return Integer.parseInt(elements[0]) + Integer.parseInt(elements[1]) == Integer.parseInt(elements[2]);
        } catch (Exception e) {
            // если в элементах присутствует знак ? вызывается exception, соотвественно
            // равенсто не равно
            return false;
        }
    }

    // рекурсивная функция где мы последовательно меняем знаки ? на числа от 0 до 9
    public static String[] calcExpression(String[] elements) {
        for (int i = 0; i < elements.length; i++) {
            // если в текущем элементе присуствует ? то нужно попробовать его заменить
            if (elements[i].indexOf("?") != -1) {
                for (int j = 0; j < 10; j++) {
                    // создаем копию наших элементов и меняем знак ? на число от 0 до 9 и вызываем
                    // данную функцию еще раз
                    String[] components = Arrays.copyOf(elements, elements.length);
                    components[i] = components[i].replaceFirst("\\?", "" + j);
                    components = calcExpression(components);
                    if (isSolved(components))
                        return components;
                }
            }
        }
        // если в уравнении нет больше ?, значит дальше нужно будет проверить его
        return elements;
    }
}
