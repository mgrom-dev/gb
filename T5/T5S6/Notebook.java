import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * -Подумать над структурой класса Ноутбук для магазина техники - выделить поля
 * и методы. Реализовать в java.
 * -Создать множество ноутбуков.
 * -Написать метод, который будет запрашивать у пользователя критерий (или
 * критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии
 * фильтрации можно хранить в Map. Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * -Далее нужно запросить минимальные значения для указанных критериев -
 * сохранить параметры фильтрации можно также в Map.
 * -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
 * условиям.
 */
public class Notebook {
    private String brand;
    private int ram; // ОЗУ в ГБ
    private int storage; // Объем ЖД в ГБ
    private String os; // Операционная система
    private String color;
    private double price; // Цена
    private String processor; // Процессор
    private String graphicsCard; // Видеокарта

    public static Set<Notebook> store = new HashSet<>();

    public static void main(String[] args) {
        // создаем экземпляры класса
        store.add(new Notebook("Lenovo", 8, 512, "Windows", "Black", 600.0, "Intel i5", "Nvidia GTX 1050"));
        store.add(new Notebook("Dell", 16, 1024, "Linux", "Silver", 1200.0, "Intel i7", "AMD Radeon 560"));
        store.add(new Notebook("HP", 4, 256, "Windows", "White", 400.0, "AMD Ryzen 3", "Intel UHD Graphics"));
        store.add(new Notebook("Asus", 12, 512, "Windows", "Grey", 800.0, "AMD Ryzen 5", "Nvidia GTX 1650"));
        store.add(new Notebook("Acer", 16, 1024, "Windows", "Black", 1100.0, "Intel i7", "AMD Radeon RX 5600M"));
        store.add(new Notebook("MSI", 32, 2048, "Windows", "Silver", 2000.0, "Intel i9", "Nvidia RTX 3080"));
        store.add(new Notebook("Apple", 8, 512, "macOS", "Silver", 1500.0, "Apple M1", "Integrated"));
        store.add(new Notebook("Lenovo", 16, 512, "Windows", "Black", 1000.0, "AMD Ryzen 7", "Nvidia GTX 1660 Ti"));
        store.add(new Notebook("Dell", 8, 256, "Linux", "Black", 600.0, "Intel i5", "Intel UHD Graphics"));
        store.add(new Notebook("HP", 12, 512, "Windows", "White", 900.0, "AMD Ryzen 5", "Nvidia MX350"));
        store.add(new Notebook("Samsung", 16, 512, "Windows", "Blue", 1200.0, "Intel i7", "Nvidia GTX 1650"));
        store.add(new Notebook("Microsoft", 8, 256, "Windows", "Silver", 1000.0, "Intel i5", "Intel Iris Xe"));
        store.add(new Notebook("Razer", 32, 2048, "Windows", "Black", 2500.0, "Intel i9", "Nvidia RTX 3090"));

        Scanner scanner = new Scanner(System.in);

        Map<String, Object> filters = getFilterNumbers(scanner);

        filterLaptops(filters);
    }

    // запрашиваем у пользователя критерии фильтрации
    public static Map<String, Object> getFilterNumbers(Scanner scanner) {
        Map<String, Object> filters = new HashMap<>();
        System.out.println("Выберите критерии фильтрации:");
        System.out.println("1 - ОЗУ, 2 - Объем ЖД, 3 - Операционная система, 4 - Цвет, 5 - Цена");
        System.out.print("Введите номера критериев через запятую: ");
        String[] filterNumbers = scanner.nextLine().split(",");
        // проходим по всем выбранным фильтрам
        for (String filterNumber : filterNumbers) {
            switch (filterNumber.trim()) {
                case "1":
                    System.out.print("Введите минимальный объем ОЗУ: ");
                    int ramFilter = Integer.parseInt(scanner.nextLine().trim());
                    filters.put("ram", ramFilter);
                    break;
                case "2":
                    System.out.print("Введите минимальный объем ЖД: ");
                    int storageFilter = Integer.parseInt(scanner.nextLine().trim());
                    filters.put("storage", storageFilter);
                    break;
                case "3":
                    System.out.print("Введите операционную систему: ");
                    String osFilter = scanner.nextLine().trim();
                    filters.put("os", osFilter);
                    break;
                case "4":
                    System.out.print("Введите цвет: ");
                    String colorFilter = scanner.nextLine().trim();
                    filters.put("color", colorFilter);
                    break;
                case "5":
                    System.out.print("Введите максимальную цену: ");
                    double priceFilter = Double.parseDouble(scanner.nextLine().trim());
                    filters.put("price", priceFilter);
                    break;
                default:
                    System.out.println("Неверный номер критерия. Пропускаем...");
                    break;
            }
        }
        return filters;
    }

    // фильтруем по заданным критериям и выводим подходящие
    public static void filterLaptops(Map<String, Object> filters) {
        // проходим по всем экземплярам ноутбуков в магазине
        for (Notebook notebook : store) {
            boolean passFilter = true; // индикатор соответствия фильтру
            // проходим по всем фильтрам
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {
                    case "ram":
                        if (notebook.getRam() < (int) value)
                            passFilter = false;
                        break;
                    case "storage":
                        if (notebook.getStorage() < (int) value)
                            passFilter = false;
                        break;
                    case "os":
                        if (!notebook.getOs().equalsIgnoreCase((String) value))
                            passFilter = false;
                        break;
                    case "color":
                        if (!notebook.getColor().equalsIgnoreCase((String) value))
                            passFilter = false;
                        break;
                    case "price":
                        if (notebook.getPrice() > (double) value)
                            passFilter = false;
                        break;
                    default:
                        break;
                }
                if (!passFilter) {
                    break;
                }
            }
            if (passFilter) {
                System.out.println(notebook);
            }
        }
    }

    // конструктор класса
    public Notebook(String brand, int ram, int storage, String os, String color, double price, String processor,
            String graphicsCard) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.price = price;
        this.processor = processor;
        this.graphicsCard = graphicsCard;
    }

    // переопределяем методы сравнения, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Notebook notebook = (Notebook) o;
        return ram == notebook.ram && storage == notebook.storage && Double.compare(notebook.price, price) == 0
                && Objects.equals(brand, notebook.brand) && Objects.equals(os, notebook.os)
                && Objects.equals(color, notebook.color) && Objects.equals(processor, notebook.processor)
                && Objects.equals(graphicsCard, notebook.graphicsCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, ram, storage, os, color, price, processor, graphicsCard);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", processor='" + processor + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                '}';
    }

    // геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public static Set<Notebook> getStore() {
        return store;
    }

    public static void setStore(Set<Notebook> store) {
        Notebook.store = store;
    }

}
