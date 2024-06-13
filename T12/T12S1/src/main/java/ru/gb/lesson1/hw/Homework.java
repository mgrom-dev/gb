package ru.gb.lesson1.hw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class Homework {

  public static void main(String[] args) {
    Department dep1 = new Department("Менеджеры");
    Department dep2 = new Department("Программисты");
    Department dep3 = new Department("Бухгалтерия");

    List<Person> persons = new ArrayList<>();
    persons.add(new Person("Вася", 25, 50_000, dep1));
    persons.add(new Person("Иван", 32, 80_000, dep1));
    persons.add(new Person("Дмитрий", 22, 70_000, dep2));
    persons.add(new Person("Марк", 28, 120_000, dep2));
    persons.add(new Person("Галя", 30, 100_000, dep3));
    persons.add(new Person("Олеся", 35, 110_000, dep3));
    System.out.println();

    System.out.println("Самый молодой сотрудник: " + findMostYoungestPerson(persons).get().getName());

    Optional<Department> mostExpensiveDepartment = findMostExpensiveDepartment(persons);
    System.out.println("Департамент с самой большой зарплатой: " + mostExpensiveDepartment.get().getName());

    System.out.println("------------------");

    groupByDepartment(persons).forEach((dept, pers) -> {
      System.out.println("Департамент: " + dept.getName());
      pers.forEach(p -> System.out.println(" - " + p.getName()));
    });

    System.out.println("------------------");

    groupByDepartmentName(persons).forEach((dept, pers) -> {
      System.out.println("Департамент: " + dept);
      pers.forEach(p -> System.out.println(" - " + p.getName()));
    });

    System.out.println("------------------");

    Map<String, Person> oldestInDept = getDepartmentOldestPerson(persons);
    oldestInDept.forEach((deptName, person) -> {
      System.out.println("Самый старший в департаменте " + deptName + ": " + person.getName());
    });

    System.out.println("------------------");

    List<Person> cheapPersons = cheapPersonsInDepartment(persons);
    cheapPersons.forEach(p -> {
      System.out.println("Самый дешевый сотрудник в департаменте " + p.getDepart().getName() + ": " + p.getName());
    });
  }

  private static class Department {
    private String name;

    public String getName() {
      return name;
    }

    public Department(String name) {
      this.name = name;
    }
  }

  private static class Person {
    private String name;
    private int age;
    private double salary;
    private Department depart;

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public double getSalary() {
      return salary;
    }

    public Department getDepart() {
      return depart;
    }

    public Person(String name, int age, double salary, Department depart) {
      this.name = name;
      this.age = age;
      this.salary = salary;
      this.depart = depart;
    }
  }

  /**
   * Найти самого молодого сотрудника
   */
  static Optional<Person> findMostYoungestPerson(List<Person> people) {
    return people.stream()
        .min(Comparator.comparingInt(Person::getAge));
  }

  /**
   * Найти департамент, в котором работает сотрудник с самой большой зарплатой
   */
  static Optional<Department> findMostExpensiveDepartment(List<Person> people) {
    return people.stream()
        .max(Comparator.comparingDouble(Person::getSalary))
        .map(Person::getDepart);
  }

  /**
   * Сгруппировать сотрудников по департаментам
   */
  static Map<Department, List<Person>> groupByDepartment(List<Person> people) {
    return people.stream()
        .collect(Collectors.groupingBy(Person::getDepart));
  }

  /**
   * Сгруппировать сотрудников по названиям департаментов
   */
  static Map<String, List<Person>> groupByDepartmentName(List<Person> people) {
    return people.stream()
        .collect(Collectors.groupingBy(person -> person.getDepart().getName()));
  }

  /**
   * В каждом департаменте найти самого старшего сотрудника
   */
  static Map<String, Person> getDepartmentOldestPerson(List<Person> people) {
    return groupByDepartmentName(people).entrySet().stream()
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            entry -> entry.getValue().stream()
                .max(Comparator.comparingInt(Person::getAge))
                .get()));
  }

  /**
   * *Найти сотрудников с минимальными зарплатами в своем отделе
   * (прим. можно реализовать в два запроса)
   */
  static List<Person> cheapPersonsInDepartment(List<Person> people) {
    return groupByDepartmentName(people).values().stream()
        .map(persons -> persons.stream()
            .min(Comparator.comparingDouble(Person::getSalary))
            .get())
        .collect(Collectors.toList());
  }

}
