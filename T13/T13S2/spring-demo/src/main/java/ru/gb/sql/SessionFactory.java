package ru.gb.sql;

import java.sql.Connection;

// hibernate
public class SessionFactory {

  private final Connection connection;

  public SessionFactory(Connection connection) {
    this.connection = connection;
  }

}
