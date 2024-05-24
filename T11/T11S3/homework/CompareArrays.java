package homework;

/**
 * Напишите обобщенный метод compareArrays(), который принимает два массива и
 * возвращает true, если они одинаковые, и false в противном случае. Массивы
 * могут быть любого типа данных, но должны иметь одинаковую длину и содержать
 * элементы одного типа по парно по индексам.
 */
public class CompareArrays {
    public static <F, S> boolean compareArrays(F[] first, S[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++)
            if (!first[i].getClass().getName().equals(second[i].getClass().getName()))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Cat[] cats = {new Cat("Boris"), new Cat("Murzik"), new Cat("Baton")};
        Dog[] dogs = {new Dog("Sharik"), new Dog("Barbos"), new Dog("Rex")};
        Animal[] animals = {new Cat("Simba"), new Cat(), new Cat("Whiskas")};
        System.out.println("Compare cats and dogs: " + CompareArrays.compareArrays(cats, dogs));
        System.out.println("Compare animals and dogs: " + CompareArrays.compareArrays(animals, dogs));
        System.out.println("Compare animals and cats: " + CompareArrays.compareArrays(animals, cats));
    }
}
