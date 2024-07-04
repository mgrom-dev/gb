package ru.gb.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class Prototype {

  private static long counter = 1L;

  private final Long id;

  @Autowired
  public Prototype() {
    id = counter++;
  }

  @PostConstruct
  public void init() {
    System.out.println("Prototype #" + id + " INIT");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Prototype #" + id + " DESTROY");
  }

  public Long getId() {
    return id;
  }

}
