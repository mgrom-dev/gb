/**
 * ѕревратите фрагменты кода с классом lncrementable в работающую программу.
 * Ќапишите программу, котора€ демонстрирует, что независимо от количества
 * созданных объектов класс содержит только один экземпл€р пол€ static.
 */
public class Incrementable {
    static class StaticTest {
        static int i = 47;
    }

    static void increment() {
        StaticTest.i++;
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        StaticTest st1 = new StaticTest(); // создаем 2 экзмепл€ра класса
        StaticTest st2 = new StaticTest(); // статическое поле i существует только в 1 экземпл€ре
        StaticTest.i++; // инкрементируем значение i
        System.out.printf("st1.i: %d, st2.i: %d\n", st1.i, st2.i); // значени€ i одинаковые 48
        Incrementable sf = new Incrementable(); // создаем новый класс
        sf.increment(); // при обращении через экземпл€р класса, будет вызван один и тот же метод
        Incrementable.increment(); // статический метод
        System.out.printf("st1.i: %d, st2.i: %d\n", st1.i, st2.i); // 50
    }
}
