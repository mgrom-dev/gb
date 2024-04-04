package book.chapter2;

/**
 * Превратите фрагменты кода с классом lncrementable в работающую программу.
 * Напишите программу, которая демонстрирует, что независимо от количества
 * созданных объектов класс содержит только один экземпляр поля static.
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
        StaticTest st1 = new StaticTest(); // создаем 2 экзмепляра класса
        StaticTest st2 = new StaticTest(); // статическое поле i существует только в 1 экземпляре
        StaticTest.i++; // инкрементируем значение i
        System.out.printf("st1.i: %d, st2.i: %d\n", st1.i, st2.i); // значения i одинаковые 48
        Incrementable sf = new Incrementable(); // создаем новый класс
        sf.increment(); // при обращении через экземпляр класса, будет вызван один и тот же метод
        Incrementable.increment(); // статический метод
        System.out.printf("st1.i: %d, st2.i: %d\n", st1.i, st2.i); // 50
    }
}
