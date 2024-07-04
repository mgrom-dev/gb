package ru.gb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import ru.gb.sql.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

//@Configuration
public class HibernateConfiguration {

  // circular dependency
  // ParentBean -> (BeanA, BeanB)
  // BeanA -> BeanB
  // BeanB -> BeanA

  @Primary
  @Bean(name = "postgresConnection")
  public Connection postgresConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
  }

  // BeanDefinition -> BeanFactory -> Bean
  @Bean
  public Connection h2Connection() throws SQLException {
    return DriverManager.getConnection("jdbc:h2:mem:test");
  }

//  @Bean
//  public SessionFactory sessionFactory(Connection connection) {
//    return new SessionFactory(connection);

//    org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
//    configuration.configure();
//
//    return configuration.buildSessionFactory();
//  }

}
