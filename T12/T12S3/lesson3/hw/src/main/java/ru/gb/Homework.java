package ru.gb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Homework {
  private static final String[] DEPARTMENT_NAMES = { "HR", "Finance", "IT", "Marketing", "Sales" };
  private static final String[] PERSON_NAMES = { "Джон", "Юля", "Алиса", "Борис", "Тимофей", "Екатерина", "Михаил",
      "Саша", "Константин", "Дмитрий", "Максим", "Татьяна", "Надежда", "Андрей", "Марк", "Денис", "Тамара" };

  static record Department(long id, String name) {
  }

  static record Person(long id, String name, int age, boolean active, long department_id) {
  }

  /**
   * С помощью JDBC, выполнить следующие пункты:
   * 1. Создать таблицу Person (скопировать код с семниара)
   * 2. Создать таблицу Department (id bigint primary key, name varchar(128) not
   * null)
   * 3. Добавить в таблицу Person поле department_id типа bigint (внешний ключ)
   * 4. Написать метод, который загружает Имя department по Идентификатору person
   * 5. * Написать метод, который загружает Map<String, String>, в которой маппинг
   * person.name -> department.name
   * Пример: [{"person #1", "department #1"}, {"person #2", "department #3}]
   * 6. ** Написать метод, который загружает Map<String, List<String>>, в которой
   * маппинг department.name -> <person.name>
   * Пример:
   * [
   * {"department #1", ["person #1", "person #2"]},
   * {"department #2", ["person #3", "person #4"]}
   * ]
   *
   * 7. *** Создать классы-обертки над таблицами, и в пунктах 4, 5, 6 возвращать
   * объекты.
   */

  private static Department getPersonDepartmentName(Connection connection, long personId) throws SQLException {
    String query = """
        SELECT d.id, d.name
        FROM person p
        JOIN department d ON p.department_id = d.id
        WHERE p.id = ?
        """;

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setLong(1, personId);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          long departmentId = resultSet.getLong("id");
          String departmentName = resultSet.getString("name");
          return new Department(departmentId, departmentName);
        } else {
          throw new SQLException("Сотрудник с id " + personId + " не найден");
        }
      }
    } catch (SQLException e) {
      System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
      throw e;
    }
  }

  private static Map<Person, Department> getPersonDepartments(Connection connection) throws SQLException {
    String query = """
        SELECT p.id AS person_id, p.name AS person_name, p.age, p.active, p.department_id,
               d.id AS department_id, d.name AS department_name
        FROM person p
        JOIN department d ON p.department_id = d.id
        """;

    Map<Person, Department> personDepartmentMap = new HashMap<>();

    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        // Чтение данных сотрудника
        long personId = resultSet.getLong("person_id");
        String personName = resultSet.getString("person_name");
        int age = resultSet.getInt("age");
        boolean active = resultSet.getBoolean("active");
        long departmentId = resultSet.getLong("department_id");

        Person person = new Person(personId, personName, age, active, departmentId);

        // Чтение данных отдела
        String departmentName = resultSet.getString("department_name");
        Department department = new Department(departmentId, departmentName);

        // Добавление пары (сотрудник, отдел) в карту
        personDepartmentMap.put(person, department);
      }
    } catch (SQLException e) {
      System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
      throw e;
    }

    return personDepartmentMap;
  }

  private static Map<Department, List<Person>> getDepartmentPersons(Connection connection) throws SQLException {
    String query = """
        SELECT p.id AS person_id, p.name AS person_name, p.age, p.active, p.department_id,
               d.id AS department_id, d.name AS department_name
        FROM person p
        JOIN department d ON p.department_id = d.id
        """;

    Map<Department, List<Person>> departmentPersonsMap = new HashMap<>();

    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        // Чтение данных сотрудника
        long personId = resultSet.getLong("person_id");
        String personName = resultSet.getString("person_name");
        int age = resultSet.getInt("age");
        boolean active = resultSet.getBoolean("active");
        long departmentId = resultSet.getLong("department_id");

        Person person = new Person(personId, personName, age, active, departmentId);

        // Чтение данных отдела
        String departmentName = resultSet.getString("department_name");
        Department department = new Department(departmentId, departmentName);

        // Добавление сотрудника в список отдела
        departmentPersonsMap.computeIfAbsent(department, k -> new ArrayList<>()).add(person);
      }
    } catch (SQLException e) {
      System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
      throw e;
    }

    return departmentPersonsMap;
  }

  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test")) {
      createTables(connection);
      insertData(connection);
      selectData(connection);
      
      System.out.println(getPersonDepartmentName(connection, 5));

      getPersonDepartments(connection).entrySet()
          .forEach(e -> System.out.println(e.getKey().name() + ": " + e.getValue().name()));

      Map<Department, List<Person>> departmentPersons = getDepartmentPersons(connection);
      departmentPersons.entrySet().forEach(e -> {
        String departmentName = e.getKey().name();
        String personNames = e.getValue().stream()
            .map(Person::name)
            .collect(Collectors.joining(", "));
        System.out.println(departmentName + ": [" + personNames + "]");
      });
    } catch (SQLException e) {
      System.err.println("Во время подключения произошла ошибка: " + e.getMessage());
    }
  }

  // создание таблиц Person и Department
  private static void createTables(Connection connection) throws SQLException {
    String createPersonTable = """
        CREATE TABLE person (
          id BIGINT PRIMARY KEY,
          name VARCHAR(256),
          age INTEGER,
          active BOOLEAN,
          department_id BIGINT
        );
        """;

    String createDepartmentTable = """
        CREATE TABLE department (
          id BIGINT PRIMARY KEY,
          name VARCHAR(256)
        );
        """;

    try (Statement statement = connection.createStatement()) {
      statement.execute(createPersonTable);
      statement.execute(createDepartmentTable);
    } catch (SQLException e) {
      System.err.println("Во время создания таблицы произошла ошибка: " + e.getMessage());
      throw e;
    }
  }

  // вставка тестовых данных в таблицы Person и Department
  private static void insertData(Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      // Вставка данных в таблицу department
      StringBuilder insertDepartmentQuery = new StringBuilder("INSERT INTO department(id, name) VALUES\n");
      for (int i = 1; i <= 3; i++) {
        String departmentName = DEPARTMENT_NAMES[ThreadLocalRandom.current().nextInt(DEPARTMENT_NAMES.length)];
        insertDepartmentQuery.append(String.format("(%d, '%s_%d')", i, departmentName, i));
        if (i != 3) {
          insertDepartmentQuery.append(",\n");
        }
      }

      statement.executeUpdate(insertDepartmentQuery.toString());

      // Вставка данных в таблицу person
      StringBuilder insertPersonQuery = new StringBuilder(
          "INSERT INTO person(id, name, age, active, department_id) VALUES\n");
      for (int i = 1; i <= 10; i++) {
        String personName = PERSON_NAMES[ThreadLocalRandom.current().nextInt(PERSON_NAMES.length)];
        int age = ThreadLocalRandom.current().nextInt(20, 60);
        boolean active = ThreadLocalRandom.current().nextBoolean();
        long departmentId = ThreadLocalRandom.current().nextLong(1, 4); // Отделы с id от 1 до 3

        insertPersonQuery.append(String.format("(%d, '%s', %d, %b, %d)", i, personName, age, active, departmentId));
        if (i != 10) {
          insertPersonQuery.append(",\n");
        }
      }

      statement.executeUpdate(insertPersonQuery.toString());
    }
  }

  // вывод данных о сотрудниках
  private static void selectData(Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      // Запрос для активных сотрудников
      ResultSet personResultSet = statement.executeQuery("""
          SELECT p.id, p.name, p.age, p.active, d.name AS department_name
          FROM person p
          JOIN department d ON p.department_id = d.id
          """);

      // Вывод данных сотрудников
      System.out.println("Активные сотрудники:");
      while (personResultSet.next()) {
        long id = personResultSet.getLong("id");
        String name = personResultSet.getString("name");
        int age = personResultSet.getInt("age");
        String departmentName = personResultSet.getString("department_name");
        System.out.println("[id = " + id + ", name = " + name + ", age = " + age + ", department = "
            + departmentName + "]");
      }
    } catch (SQLException e) {
      System.err.println("Во время выборки данных произошла ошибка: " + e.getMessage());
      throw e;
    }
  }

}
