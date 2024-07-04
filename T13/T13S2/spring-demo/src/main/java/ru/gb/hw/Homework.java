package ru.gb.hw;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class Homework {

  /**
   * Напрограммировать электронную очередь.
   * 1. Класс TicketNumberGenerator - бин (синглтон), у которого есть метод
   * createNewNumber()
   * 1.1 Метод createNewNumber возвращает строки вида "Ticket #X", где X - UUID
   * (UUID.randomUUID().toString())
   *
   * Пример:
   * TicketNumberGenerator generator =
   * context.getBean(TicketNumberGenerator.class);
   * System.out.println(generator.createNewNumber()); // "Ticket
   * #b0b3a25d-2135-4b18-9dec-08d494b96b06"
   * System.out.println(generator.createNewNumber()); // "Ticket
   * #379c5673-50c3-4daf-a53f-a396a3d34535"
   * System.out.println(generator.createNewNumber()); // "Ticket
   * #b4cc4e55-69b2-4c49-867f-09735fea292a"
   *
   * 2. Создать класс Ticket (не бин!!!) с полями:
   * 2.1. String number - номер тикета
   * 2.2. LocalDateTime createdAt - дата создания
   * 2.3. ... (любые другие поля)
   *
   * 3. Класс "Табло" - бин (синглтон), у которого есть поле ticketNumberGenerator
   * и метод метод newTicket(), который создает объект класса Ticket с значениями
   * полей:
   * 3.1 number - результат вызова TicketNumberGenerator#createNewNumber
   * 3.2 createdAt - LocalDateTime.now()
   * 3.3 ...
   */

  @Component
  static record TicketNumberGenerator() {
    public String createNewNumber() {
      return "Ticket #" + UUID.randomUUID().toString();
    }
  }

  static record LocalDateTime(java.time.LocalDateTime time) {
    public static LocalDateTime now() {
      return new LocalDateTime(java.time.LocalDateTime.now());
    }

    @Override
    public String toString() {
      return time.format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy"));
    }
  }

  static record Ticket(String number, LocalDateTime createdAt, String customerName, String customerPhone) {
    @Override
    public final String toString() {
      return String.format("{%s, time: %s, phone: %s, name: %s}", number, createdAt, customerPhone, customerName);
    }
  }

  @Service
  public class TicketBoard {
    private final TicketNumberGenerator ticketNumberGenerator;
    private final List<Ticket> tickets;

    public TicketBoard(TicketNumberGenerator ticketNumberGenerator) {
      this.ticketNumberGenerator = ticketNumberGenerator;
      this.tickets = new ArrayList<>();
    }

    public Ticket newTicket(String customerName, String customerPhone) {
      String number = ticketNumberGenerator.createNewNumber();
      Ticket ticket = new Ticket(number, LocalDateTime.now(), customerName, customerPhone);
      tickets.add(ticket);
      return ticket;
    }

    public List<Ticket> getTickets() {
      return new ArrayList<>(tickets);
    }
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Homework.class, args);
    TicketBoard tb = context.getBean(TicketBoard.class);
    System.out.println("Generating Tickets:");
    System.out.println(tb.newTicket("Alexey", "1234567890"));
    System.out.println(tb.newTicket("Vladimir", "9876543210"));
    System.out.println(tb.newTicket("Zoya", "1120869188"));
    System.out.println("All tickets:");
    System.out.println(tb.getTickets());
  }

}
