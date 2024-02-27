import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 1. Создайте множество, в котором будут храниться экземпляры класса Cat -
 * HashSet<Cat>.
 * Поместите в него некоторое количество объектов.
 * 2. Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их
 * во множество.
 * Убедитесь, что все они сохранились во множество.
 * 3. Создайте метод public boolean equals(Object o)
 * Пропишите в нём логику сравнения котов по параметрам, хранимым в полях. То
 * есть, метод
 * должен возвращать true, только если значения во всех полях сравниваемых
 * объектов равны.
 * 4. Создайте метод public int hashCode()
 * который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно
 * использовать
 * Objects.hash(...))
 * 5. Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты
 * удалились.
 */
public class CatSet extends Cat {

    public CatSet(String name, String color, int age) {
        super(name, color, age);
    }

    public static void main(String[] args) {
        Set<CatSet> cats = new HashSet<>();
        cats.add(new CatSet("Barsik", "black", 2));
        cats.add(new CatSet("Baton", "orange", 3));
        cats.add(new CatSet("Rex", "yellow", 1));
        cats.add(new CatSet("Baton", "orange", 3));
        cats.add(new CatSet("Barsik", "black", 2));
        System.out.println(cats);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Cat cat = (Cat) obj;
        return cat.getName().equals(this.getName()) &&
            cat.getColor().equals(this.getColor()) &&
            cat.getAge() == this.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getColor(), this.getAge());
    }

}
