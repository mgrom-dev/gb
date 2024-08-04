package ru.gb.timesheet;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {

  public static void main(String[] args) {
    int sum = sum(2, 4);
    System.out.println(sum);
  }

  static int sum(int a, int b) {
    return a + a;
  }

  @SneakyThrows
  static Connection getConnection() {
//    try {
      return DriverManager.getConnection("jasdfadsft");
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
  }

}
