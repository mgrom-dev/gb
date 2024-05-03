import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        // очистка экрана
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
            System.out.println("\033[H\033[2J"); // комбинация ASCII для очистки экрана MAC
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // ключ = Кличка, значение = порода
        // 20 вставок
        HashMap<String, String> cats = new HashMap<>(4);
        cats.put("Мурка", "сиамская");
        cats.put("Барсик", "мейн-кун");
        cats.put("Матроскин", "норвежская лесная");
        cats.put("Васька", "британская");
        cats.put("Мурзик", "шотландская вислоухая");
        cats.put("Рыжик", "абиссинская");
        cats.put("Симба", "бенгальская");
        cats.put("Масяня", "корниш-рекс");
        cats.put("Том", "манчкин");
        cats.put("Арчи", "ориентальная");
        cats.put("Леопольд", "персидская");
        cats.put("Бусинка", "рыжая");
        cats.put("Соня", "сфинкс");
        cats.put("Люська", "шартрез");
        cats.put("Мурлыка", "мэйн-кун");
        cats.put("Маркиз", "бурманская");
        cats.put("Белка", "корат");
        cats.put("Василиса", "сомали");
        cats.put("Мурка", "манчкин");
        cats.put("Борис", "кимрик");

        // печать с помощью toString
        System.out.println(cats);

        // печать с помощью foreach iterable
        int i = 1;
        for (HashMap<String, String>.Entity element : cats) {
            System.out.println(i++ + ": " + element.key + ": " + element.value);
        }
    }
}
