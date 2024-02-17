import java.util.ArrayList;
import java.util.List;

/**
 * Каталог товаров книжного магазина сохранен в виде двумерного
 * списка List<ArrayList<String>> так, что на 0й позиции каждого
 * внутреннего списка содержится название жанра, а на остальных
 * позициях - названия книг. Напишите метод для заполнения данной
 * структуры.
 */
public class BookShop {
    public static void main(String[] args) {
        List<ArrayList<String>> catalog = new ArrayList<>();
        // Добавление данных в каталог
        addToCatalog(catalog, "Фантастика", "Книга 1", "Книга 2", "Книга 3");
        addToCatalog(catalog, "Детективы", "Книга 4", "Книга 5");
        addToCatalog(catalog, "Романы", "Книга 6", "Книга 7", "Книга 8");
        System.out.println(catalog);
        printCatalog(catalog);
    }

    private static void printCatalog(List<ArrayList<String>> catalog) {
        // Вывод каталога
        for (ArrayList<String> genre : catalog) {
            System.out.println("Жанр: " + genre.get(0));
            for (int i = 1; i < genre.size(); i++) {
                System.out.println("Книга: " + genre.get(i));
            }
            System.out.println();
        }
    }

    public static void addToCatalog(List<ArrayList<String>> catalog, String genre, String... books) {
        ArrayList<String> genreList = new ArrayList<>();
        genreList.add(genre);
        for (String book : books) {
            genreList.add(book);
        }
        catalog.add(genreList);
    }
}
