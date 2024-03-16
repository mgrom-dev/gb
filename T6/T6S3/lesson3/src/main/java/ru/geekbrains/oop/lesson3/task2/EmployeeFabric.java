package ru.geekbrains.oop.lesson3.task2;

import java.util.Arrays;
import java.util.Random;

public class EmployeeFabric {

    private static String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    private static String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
    public static final int nameLengthMax = Arrays.stream(names).mapToInt(String::length).max().orElse(0);
    public static final int surnameLengthMax = Arrays.stream(surnames).mapToInt(String::length).max().orElse(0);

    private static Random random = new Random();

    public static Worker generateWorker(){
        int salary = 60_000 + random.nextInt(60_000);
        int age = 25 + random.nextInt(40);
        return Worker.create(
                surnames[random.nextInt(surnames.length)],
                names[random.nextInt(names.length)], 
                age,
                salary);
    }

    public static Freelancer generateFreelancer(){
        int salary = 500 + random.nextInt(500);
        int age = 20 + random.nextInt(35);
        return Freelancer.create(
                surnames[random.nextInt(surnames.length)],
                names[random.nextInt(names.length)],
                age,
                salary);
    }

    public static Interns generateInterns(){
        int salary = 250 + random.nextInt(250);
        int workedHous = 20 + random.nextInt(60);
        int age = 16 + random.nextInt(10);
        return Interns.create(
                surnames[random.nextInt(surnames.length)],
                names[random.nextInt(names.length)],
                age,
                salary, 
                workedHous);
    }

    /**
     * TODO: Переработать метод generateEmployees, метод должен генерировать рабочих
     *  разных типов (Worker, Freelancer) в рамках домашней работы
     * @param count
     * @return
     */
    public static Employee[] generateEmployees(int count){
        Employee[] workers = new Employee[count];
        for (int i = 0; i < count; i++){
            if (i % 3 == 0) workers[i] = generateWorker();
            else if (i % 3 == 1) workers[i] = generateFreelancer();
            else if (i % 3 == 2) workers[i] = generateInterns();
        }
        return workers;
    }

}
