package ru.gb.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableListableBeanFactory.SCOPE_SINGLETON)
public class Singleton {

  private static long counter = 1L;

  private final Long id;
  private final Prototype prototype;

  public Singleton(Prototype prototype) {
    id = counter++;
    this.prototype = prototype;

    System.out.println("Singleton CREATED");
  }

  @PostConstruct
  public void init() {
    System.out.println("Singleton INIT");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Singleton DESTROY");
  }

  public void printIds() {
    System.out.println("Prototype(id) = " + prototype.getId());
    System.out.println("Singleton(id) = " + id);
  }

  public Long getId() {
    return id;
  }

}
