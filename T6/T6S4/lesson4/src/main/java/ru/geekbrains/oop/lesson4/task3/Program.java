package ru.geekbrains.oop.lesson4.task3;

public class Program {

    public static void main(String[] args) {

        Person person1 = new Person("FIO #1", "1000002340");
        Entity entity1 = new Entity("ENTITY #1", "1000000451");

        CreditAccount<Person> creditAccount1 = new CreditAccount<>(person1, 50);
        DebitAccount<Entity> debitAccount1 = new DebitAccount<>(entity1, 10000000);
        Transaction<Account<?>> transaction = new Transaction<>(debitAccount1, creditAccount1, 40000);
        transaction.execute();
        transaction.execute();
    }

}
