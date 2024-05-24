package homework;

/**
 * Напишите обобщенный класс Pair, который представляет собой пару значений
 * разного типа. Класс должен иметь методы getFirst(), getSecond() для получения
 * значений каждого из составляющих пары, а также переопределение метода
 * toString(), возвращающее строковое представление пары.
 */
public record Pair<F, S>(F first, S second) {

    public static void main(String[] args) {
        Pair<Cat, Dog> pair = new Pair<>(new Cat(), new Dog());
        System.out.println(pair.first());
        System.out.println(pair.second());
        System.out.println(pair);
    }

}
